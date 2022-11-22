package com.jespApiTest.CarServices.services;

import com.jespApiTest.CarServices.exception.ChangePasswordException;
import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.UserAlreadyExistException;
import com.jespApiTest.CarServices.models.Access;
import com.jespApiTest.CarServices.models.EmailConfiguration;
import com.jespApiTest.CarServices.models.User;
import com.jespApiTest.CarServices.repository.AccessRepository;
import com.jespApiTest.CarServices.repository.UserRepository;
import com.jespApiTest.CarServices.util.ChangePasswordRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
/**
 *
 * Metodi per la gestione dell'utente
 *
 * @author Elvin Iluca
 *
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccessRepository accessoRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Iterable<User> getUsers() throws InternalServerErrorException {
        try {
            return userRepository.getUsers();
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    @Transactional
    public void createUser(User user) throws InternalServerErrorException {
        log.debug(user.toString());

        log.debug("Creazione nuovo utente");

        try {
            if(accessoRepository.findByUsername(user.getUsername()) != null){
                throw new UserAlreadyExistException(user.getUsername());
            }

            Access accessoUtente = new Access();
            accessoUtente.setUsername(user.getUsername());
            System.out.println(user.getPassword());
            accessoUtente.setPassword(encodePassword(user.getPassword()));


            accessoRepository.save(accessoUtente);
            log.debug("Dati di accesso aggiunti");
            user.setIsactive(0);
            User nuovoUtente = userRepository.save(user);
            int activationCode = (int)(Math.random() * (999999 - 100000 + 1) + 100000);
            userRepository.setCode(nuovoUtente.getUsername(),activationCode);
            log.debug("Nuovo utente creato");

            log.debug("Invio email al nuovo utente {}", nuovoUtente.getId());
            EmailConfiguration email = new EmailConfiguration();
            //String activationLink = "localhost:8080/user/activate/" + user.getUsername() + "/" + user.getCode();
            String activationLink = "<a href=\"" + "http://www.localhost:8080/user/activate/" + user.getUsername() + "/" + activationCode +"\">clicca qui</a>";
            email.setBody("<p1>Benvenuto " + user.getNome() +", per attivare l'account </p1>" + activationLink +".");
            //email.setBody("<p1>Benvenuto ");
            email.setSubject("Car Services attivazione utente");
            email.setTo(user.getEmail());
            email.setUsername(user.getUsername());

            EmailService emailService = new EmailService(javaMailSender, email);
            emailService.sendEmail();
            log.debug("Email al nuovo utente {} inviata", nuovoUtente.getId());

        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    public void cambioPassword(ChangePasswordRequestModel changePasswordRequestModel, Long id) throws InternalServerErrorException, ChangePasswordException {
        try {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (checkPassword(changePasswordRequestModel.getOldPassword(), user.getPassword())) {
                accessoRepository.changePassword(user.getUsername(), encodePassword(changePasswordRequestModel.getNewPassword()));
            }
            else {
                throw new ChangePasswordException("Le password non coincidono");
            }
            log.info("L'utente {} ha effettuato il cambio password con successo", id);
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    public void attivaUser(String username, int activationCode) throws InternalServerErrorException {
        try{
            User user = userRepository.findByUsername(username);
            if(activationCode == user.getCode()){
                userRepository.setActive(username,1);
            }
            else {
                throw new InternalServerErrorException("codice errato");
            }
        } catch (Exception exception) {
            throw new InternalServerErrorException(exception);
        }
    }

    public String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPassword = encoder.encode(password);
        System.out.println("eccoci qua" + encPassword);
        return encPassword;
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);
    }


}
