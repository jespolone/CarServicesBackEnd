package com.jespApiTest.CarServices.controller;

import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.UnauthorizedException;
import com.jespApiTest.CarServices.models.JwtRequest;
import com.jespApiTest.CarServices.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Servizi REST Authentication
 *
 * @author Iluca Elvin
 *
 */
@CrossOrigin
@RestController
public class    AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws UnauthorizedException, InternalServerErrorException {
        System.out.println("questo va");
        System.out.println(authenticationRequest);
        return authenticationService.createAuthenticationToken(authenticationRequest);
    }
}