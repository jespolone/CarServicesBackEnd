package com.jespApiTest.CarServices.controller;

import com.jespApiTest.CarServices.exception.InactiveUserException;
import com.jespApiTest.CarServices.exception.InternalServerErrorException;
import com.jespApiTest.CarServices.exception.UnauthorizedException;
import com.jespApiTest.CarServices.models.JwtRequest;
import com.jespApiTest.CarServices.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/auth/signin")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws UnauthorizedException, InactiveUserException, InternalServerErrorException{
        return authenticationService.createAuthenticationToken(authenticationRequest);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnauthorizedException.class)
    public String handleUnauthorizedException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InactiveUserException.class)
    public String handleInactiveUserException() {
        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
    }
}