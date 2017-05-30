package com.vz.pc.wireless.transport.auditservice.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Date time;
	public HttpStatus httpStatus;
	public String code;
	public String message;
	public String cable;

	public ErrorResponse(HttpStatus httpStatus, String code, String message,
			String cable) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.cable = cable;
		this.time = new Date();

	}

	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
	
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getCable() {
		return this.cable;
	}

	public void setCable(String cable) {
		this.cable = cable;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	

}