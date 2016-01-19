package com.vz.pc.wireless.transport.auditservice.model;

import java.util.Date;


public class AuditEventRequest {
	
	private Date TimeStamp;
	
	private String userId;
	
	private String logMsg;
	
	private Long pcOrderId;

	public Long getPcOrderId() {
		return pcOrderId;
	}

	public void setPcOrderId(Long pcOrderId) {
		this.pcOrderId = pcOrderId;
	}

	public Date getTimeStamp() {
		return TimeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		TimeStamp = timeStamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogMsg() {
		return logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	
	
}
