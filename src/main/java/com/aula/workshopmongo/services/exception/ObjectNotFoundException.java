package com.aula.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 4496829974881599076L;
	
	public ObjectNotFoundException(String message) {
		super(message);
	}
}
