package com.jespApiTest.CarServices.exception;

/**
 *
 * Custom Exception
 *
 * @author Elvin Iluca
 *
 */

public class ChangePasswordException extends RuntimeException{

    public ChangePasswordException(String message){
        super(message);
    }

}
