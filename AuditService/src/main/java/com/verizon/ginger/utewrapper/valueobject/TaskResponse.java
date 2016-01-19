package com.verizon.ginger.utewrapper.valueobject;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "TaskResponse")
@XmlType(namespace = "http://utewrapper.verizon.com")
public class TaskResponse {

	
	public static final String TAG_TASK_STATUS = "state";
	public static final String TAG_UPDATE_VERSION = "version";
	public static final String TAG_TASK_ID = "taskId";
	public static final String TAG_EXT_TASK_ID = "externalTaskId";
	
	public static final String XPATH_ASSIGNMENT_INFO= "taskHeader/taskHeader";
	public static final String XPATH_FAULT_CODE = "Body/Fault/detail/VZTaskFault/FaultCode";
	public static final String XPATH_FAULT_DESC = "Body/Fault/detail/VZTaskFault/FaultDescription";
	public static final String XPATH_FAULT_TYPE = "Body/Fault/detail/VZTaskFault/FaultType";
	

	private String uteTaskId;
	private String externalTaskId;
	private String taskStatus;
	private String updatedVersion;
	private String userId;
			
	private String faultCode;
	private String faultType;
	private String faultDescription;
	
	public String getUteTaskId() {
		return uteTaskId;
	}
	public void setUteTaskId(String uteTaskId) {
		this.uteTaskId = uteTaskId;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	public String getFaultType() {
		return faultType;
	}
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFaultDescription() {
		return faultDescription;
	}
	public void setFaultDescription(String faultDescription) {
		this.faultDescription = faultDescription;
	}
	
	public String getUpdatedVersion() {
		return updatedVersion;
	}
	public void setUpdatedVersion(String updatedVersion) {
		this.updatedVersion = updatedVersion;
	}
	public String getExternalTaskId() {
		return externalTaskId;
	}
	public void setExternalTaskId(String externalTaskId) {
		this.externalTaskId = externalTaskId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskResponse [uteTaskId=");
		builder.append(uteTaskId);
		builder.append(", externalTaskId=");
		builder.append(externalTaskId);
		builder.append(", taskStatus=");
		builder.append(taskStatus);
		builder.append(", updatedVersion=");
		builder.append(updatedVersion);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", faultCode=");
		builder.append(faultCode);
		builder.append(", faultType=");
		builder.append(faultType);
		builder.append(", faultDescription=");
		builder.append(faultDescription);
		builder.append("]");
		return builder.toString();
	}

	
}
