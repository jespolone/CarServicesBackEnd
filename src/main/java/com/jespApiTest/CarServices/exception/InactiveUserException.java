package com.jespApiTest.CarServices.exception;

/**
 *
 * Custom Exception
 *
 * @author Elvin Iluca
 *
 */

public class InactiveUserException extends RuntimeException{

    public InactiveUserException(String message){
        super(message);
    }


}
