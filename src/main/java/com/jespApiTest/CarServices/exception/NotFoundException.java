package com.jespApiTest.CarServices.exception;

/**
 *
 * Custom Exception
 *
 * @author Elvin Iluca
 *
 */

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1204435798489323048L;
	
	public NotFoundException(String message) {
		super(message);
	}

}
