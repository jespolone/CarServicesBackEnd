package com.jespApiTest.CarServices.exception;

/**
 *
 * Custom Exception
 *
 * @author Elvin Iluca
 *
 */

public class InternalServerErrorException extends RuntimeException{
	
	/**
	The Serial Version ID is used when serializing and deserializing an object. 
	Java recognizes if the bytes you want to deserialize match the local class 
	version. If not it will throw an exception.
	 */
	
	private static final long serialVersionUID = -6480980950616906535L;
	
	public InternalServerErrorException(String message){
		super(message);
	}

	public InternalServerErrorException(Throwable cause){
        super(cause);
    }
}
