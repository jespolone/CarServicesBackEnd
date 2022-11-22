package com.jespApiTest.CarServices.exception;


/**
 *
 * Custom Exception
 *
 * @author Elvin Iluca
 *
 */

public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String message){
        super(message);
    }
}
