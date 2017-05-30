package com.expense.master.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Method failed")
public class MethodFailureException extends RuntimeException {

	private static final long serialVersionUID = -3992797190692194686L;

	public MethodFailureException(String type, String identifier, String msg){
		super(type +" "+ identifier +" "+ msg);
	}
	

}