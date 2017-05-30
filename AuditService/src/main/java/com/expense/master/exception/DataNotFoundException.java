package com.vz.pc.wireless.transport.auditservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such data")
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3992797190692194686L;


	public DataNotFoundException(String type, String identifier, String msg){
		super(type +" "+ identifier +" "+ msg);
	}
}
