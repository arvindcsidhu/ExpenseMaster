package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;

import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskinst")
public class TaskInst {
	

	@Id
	private Long taskid;
	
	private String taskName;
	
	private String pcORderNumber;
	
	private String pon;
	
	private String ponVersion;
	
	private String icsc;
	
	private Date taskCreatedTime;
	
	private Date expectedTimeOFArrival;
	
	private Date taskCompletionTime;
	
	private Date eventCreationTime;
	
	private String userId;
	
	private String taskStatus;
	
	private String statusCode;

	private String statusMesaage;
	
	private String uteResponsecode;
	
	private String uteResponseMsg;

	private String source;	


	public HashMap<String,String> preCheck ;
	
	private String uteTaskId ;
	
	public TaskInst(){
	}



	public TaskInst(Long taskid, String taskName, String pcORderNumber, String pon, String ponVersion, String icsc, Date taskCreatedTime,
			Date expectedTimeOFArrival, Date taskCompletionTime, Date eventCreationTime, String userId, String taskStatus, String statusCode,
			String statusMesaage, String uteResponsecode, String uteResponseMsg  , String source , HashMap< String , String > preCheck ) {
		this.taskid = taskid;
		this.taskName = taskName;
		this.pcORderNumber = pcORderNumber;
		this.pon = pon;
		this.ponVersion = ponVersion;
		this.icsc = icsc;
		this.taskCreatedTime = taskCreatedTime;
		this.expectedTimeOFArrival = expectedTimeOFArrival;
		this.taskCompletionTime = taskCompletionTime;
		this.eventCreationTime = eventCreationTime;
		this.userId = userId;
		this.taskStatus = taskStatus;
		this.statusCode = statusCode;
		this.statusMesaage = statusMesaage;
		this.uteResponsecode = uteResponsecode;
		this.uteResponseMsg = uteResponseMsg;
		this.source = source;
		this.preCheck = preCheck;
		
	}


	public String getUteTaskId() {
		return uteTaskId;
	}



	public void setUteTaskId(String uteTaskId) {
		this.uteTaskId = uteTaskId;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public Date getTaskCreatedTime() {
		return taskCreatedTime;
	}


	public Date getExpectedTimeOFArrival() {
		return expectedTimeOFArrival;
	}


	public Date getTaskCompletionTime() {
		return taskCompletionTime;
	}


	public Date getEventCreationTime() {
		return eventCreationTime;
	}


	public void setTaskCreatedTime(Date taskCreatedTime) {
		this.taskCreatedTime = taskCreatedTime;
	}


	public void setExpectedTimeOFArrival(Date expectedTimeOFArrival) {
		this.expectedTimeOFArrival = expectedTimeOFArrival;
	}


	public void setTaskCompletionTime(Date taskCompletionTime) {
		this.taskCompletionTime = taskCompletionTime;
	}


	public void setEventCreationTime(Date eventCreationTime) {
		this.eventCreationTime = eventCreationTime;
	}


	public Long getTaskid() {
		return taskid;
	}


	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public String getPcORderNumber() {
		return pcORderNumber;
	}


	public void setPcORderNumber(String pcORderNumber) {
		this.pcORderNumber = pcORderNumber;
	}


	public String getPon() {
		return pon;
	}


	public void setPon(String pon) {
		this.pon = pon;
	}


	public String getPonVersion() {
		return ponVersion;
	}


	public void setPonVersion(String ponVersion) {
		this.ponVersion = ponVersion;
	}


	public String getIcsc() {
		return icsc;
	}


	public void setIcsc(String icsc) {
		this.icsc = icsc;
	}


/*	public DateTime getTaskCreatedTime() {
		return taskCreatedTime;
	}


	public void setTaskCreatedTime(DateTime taskCreatedTime) {
		this.taskCreatedTime = taskCreatedTime;
	}


	public DateTime getExpectedTimeOFCompletion() {
		return expectedTimeOFCompletion;
	}


	public void setExpectedTimeOFCompletion(DateTime expectedTimeOFCompletion) {
		this.expectedTimeOFCompletion = expectedTimeOFCompletion;
	}


	public DateTime getEventCreationtime() {
		return eventCreationtime;
	}


	public void setEventCreationtime(DateTime eventCreationtime) {
		this.eventCreationtime = eventCreationtime;
	}


	public DateTime getEventCompletedTime() {
		return eventCompletedTime;
	}


	public void setEventCompletedTime(DateTime eventCompletedTime) {
		this.eventCompletedTime = eventCompletedTime;
	}*/


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getTaskStatus() {
		return taskStatus;
	}


	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}


	public String getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}


	public String getStatusMesaage() {
		return statusMesaage;
	}


	public void setStatusMesaage(String statusMesaage) {
		this.statusMesaage = statusMesaage;
	}


	public String getUteResponsecode() {
		return uteResponsecode;
	}


	public void setUteResponsecode(String uteResponsecode) {
		this.uteResponsecode = uteResponsecode;
	}


	public String getUteResponseMsg() {
		return uteResponseMsg;
	}


	public void setUteResponseMsg(String uteResponseMsg) {
		this.uteResponseMsg = uteResponseMsg;
	}



	public HashMap<String, String> getPreCheck() {
		return preCheck;
	}



	public void setPreCheck(HashMap<String, String> preCheck) {
		this.preCheck = preCheck;
	}



	@Override
	public String toString() {
		return "TaskInst [taskid=" + taskid + ", taskName=" + taskName + ", pcORderNumber=" + pcORderNumber + ", pon=" + pon + ", ponVersion=" + ponVersion
				+ ", icsc=" + icsc + ", taskCreatedTime=" + taskCreatedTime + ", expectedTimeOFArrival=" + expectedTimeOFArrival + ", taskCompletionTime="
				+ taskCompletionTime + ", eventCreationTime=" + eventCreationTime + ", userId=" + userId + ", taskStatus=" + taskStatus + ", statusCode="
				+ statusCode + ", statusMesaage=" + statusMesaage + ", uteResponsecode=" + uteResponsecode + ", uteResponseMsg=" + uteResponseMsg + ", source="
				+ source + ", preCheck=" + preCheck + ", uteTaskId=" + uteTaskId + "]";
	}









}
