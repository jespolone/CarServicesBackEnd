package com.jespApiTest.CarServices.exception;

/**
 *
 * Custom Exception
 *
 * @author Elvin Iluca
 *
 */

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message){
        super(message);
    }

}
