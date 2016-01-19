package com.vz.pc.wireless.transport.auditservice.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vz.pc.wireless.transport.auditservice.model.AuditEventRequest;

@Configuration
public class TaskCreationValidator implements Validator{
	
	private static Logger logger = LoggerFactory.getLogger(TaskCreationValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return AuditEventRequest.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AuditEventRequest request = (AuditEventRequest) target;
		

		if (request == null) {
			logger.info("Validating If Remarks Request is Empty", request);
			errors.rejectValue("RemarksRequest", "RemarksRequest", "Empty request");
		}
		
		if(request.getTimeStamp() != null && request.getTimeStamp().toString().length() == 0){
			logger.info("Requested TimeStamp Length is:", 0);
			errors.rejectValue("TimeStamp", "TimeStamp.invalid", new Object[] { request.getTimeStamp() }, "TimeStamp " + request.getTimeStamp() + "  Date is Invalid");
		}
		
		if(request.getUserId() != null && request.getUserId().trim().length() == 0){
			logger.info("Requested User Id Length is:", 0);
			errors.rejectValue("User Id", "User Id.invalid", new Object[] { request.getUserId() },
					"[ " + request.getUserId() + " ] should be 1 character long");
		}
		
		if(request.getLogMsg() != null && request.getLogMsg().trim().length() == 0){
			logger.info("Requested LogMsg Length is:", 0);
			errors.rejectValue("LogMsg", "LogMsg.invalid", new Object[] { request.getLogMsg() },
					"[ " + request.getLogMsg() + " ] should be 1 character long");
		}
		
	}

}

