package com.vz.pc.wireless.transport.auditservice.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vz.pc.wireless.transport.auditservice.model.ErrorResponse;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public List<ErrorResponse> handleMethodArgumentNotValid(HttpServletRequest req, BindException ex) {

		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		List<ErrorResponse> errorList = new ArrayList<ErrorResponse>();

		for (ObjectError e : errors) {
			if (e instanceof FieldError) {
				FieldError fe = (FieldError) e;
				errorList.add(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getCode(),
						fe.getField() + " " + e.getDefaultMessage(), req.getRequestURI()));
			} else {
				errorList.add(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getCode(), e.getDefaultMessage(),
						req.getRequestURI()));
			}

		}
		return errorList;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public List<ErrorResponse> handleMethodArgumentNotValid(HttpServletRequest req, BadRequestException ex) {

		FieldError e = ex.getError();
		List<ErrorResponse> errorList = new ArrayList<ErrorResponse>();
		errorList.add(new ErrorResponse(HttpStatus.BAD_REQUEST, e.getObjectName(),
				e.getField() + " " + e.getDefaultMessage(), req.getRequestURI()));
		return errorList;
	}

}
