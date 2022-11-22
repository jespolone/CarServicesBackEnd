package com.jespApiTest.CarServices.services;

import com.jespApiTest.CarServices.models.EmailConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;

/**
 *
 * Espone un singolo metodo per l'invio di una email
 *
 * @author Piero Aiello
 * @author Alessio Brancatelli
 */
@Service
@Slf4j
public class EmailService{

    private final JavaMailSender javaMailSender;
    private final EmailConfiguration emailConfiguration;

    public EmailService( JavaMailSender javaMailSender, EmailConfiguration emailConfiguration) {
        this.javaMailSender = javaMailSender;
        this.emailConfiguration = emailConfiguration;
    }

    public void sendEmail() throws MessagingException {
        log.info("Invio Email in corso...");
        Context context = new Context();
        context.setVariable("userInfo", emailConfiguration);
        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(emailConfiguration.getSubject());
        helper.setText(emailConfiguration.getBody(), true);
        helper.setTo(emailConfiguration.getTo());

        javaMailSender.send(mimeMessage);
        log.info("Email inviata con successo.");
    }
}
