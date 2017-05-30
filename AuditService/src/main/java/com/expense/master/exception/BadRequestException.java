package com.expense.master.exception;

import org.springframework.validation.FieldError;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -3992797190692194686L;
	FieldError error;

	public BadRequestException(FieldError error) {
		super(error.getField() + " " + error.getCode() + " " +  error.getDefaultMessage());
		this.error  = error;
	}

	public FieldError getError() {
		return error;
	}
	
}
