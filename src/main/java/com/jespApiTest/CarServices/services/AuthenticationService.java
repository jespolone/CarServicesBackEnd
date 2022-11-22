package com.jespApiTest.CarServices.services;

import com.jespApiTest.CarServices.exception.InactiveUserException;
import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.UnauthorizedException;
import com.jespApiTest.CarServices.models.JwtRequest;
import com.jespApiTest.CarServices.models.JwtResponse;
import com.jespApiTest.CarServices.models.User;
import com.jespApiTest.CarServices.repository.UserRepository;
import com.jespApiTest.CarServices.util.JwtTokenUtil;
import com.jespApiTest.CarServices.util.JwtUserDetailsService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * Espone un singolo metodo per l'autenticazione dell'utente
 *
 * @author Elvin Iluca
 *
 */
@Service
@Slf4j
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

//    public ResponseEntity<?> createAuthenticationToken(JwtRequest authenticationRequest) throws UnauthorizedException, InternalServerErrorException {
//        log.info("Richiesta autenticazione utente ricevuta");
//        System.out.println(authenticationRequest);
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//        try {
//            UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//            User user = userRepository.findByUsername(userDetails.getUsername());
//            String token = jwtTokenUtil.generateToken(userDetails, user);
//            log.debug("Richiesta autenticazione utente {} completata con successo", user.getId());
//            log.info("Utente {} Autenticazione completata", user.getId());
//            return ResponseEntity.ok(new JwtResponse(token));
//        }  catch (Exception exception) {
//            throw new InternalServerErrorException(exception);
//        }
//    }

    public ResponseEntity<?> createAuthenticationToken(JwtRequest authenticationRequest) throws UnauthorizedException {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        try {
            UserDetails userDetails = securityUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            User user = userRepository.findByUsername(userDetails.getUsername());
            String token = jwtTokenUtil.generateToken(userDetails, user);
            log.info("User {} is authenticated", user.getUsername());
            return ResponseEntity.ok(new JwtResponse(token));
        }  catch (Exception ex) {
            log.error(ex.getMessage());
            throw new UnauthorizedException(ex.getMessage());
        }
    }

    private void authenticate(String username, String password) throws UnauthorizedException {
        log.info("Inizio autenticazione");

        try {
            //Check user is active
            if(userRepository.getIsActive(username) == 0){
                log.info("User inattivo");
                throw new InactiveUserException("Inactive User");
            }
            String.valueOf(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)));
        } catch (DisabledException e) {
            throw new UnauthorizedException("USER_DISABLED: "+e.getMessage());
        } catch (BadCredentialsException e) {
            throw new UnauthorizedException("INVALID_CREDENTIALS: "+e.getMessage());
        }
        log.debug("Fine autenticazione");
    }

}
