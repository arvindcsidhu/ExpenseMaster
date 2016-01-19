package com.verizon.ginger.utewrapper.valueobject;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "TaskRequest")
@XmlType(namespace = "http://utewrapper.verizon.com")
public class TaskRequest {

	public static final String COL_TASK_ACTION = "TASK_ACTION";
	public static final String COL_STATUS = "STATUS";
	public static final String COL_CREATED_DATE = "CREATED_DATE";
	public static final String COL_CREATOR = "CREATOR";
	public static final String COL_DUE_DATE = "DUE_DATE";
	public static final String COL_ERROR_CODE = "ERROR_CODE";
	public static final String COL_ERROR_DESC = "ERROR_DESC";
	public static final String COL_EXT_TASK_ID = "EXT_TASK_ID";
	public static final String COL_UPDATED_DATE = "UPDATED_DATE";
	public static final String COL_OUTCOME = "OUTCOME";
	public static final String COL_TASK_TITLE = "TASK_TITLE";
	public static final String COL_USER_ID = "USER_ID";
	public static final String COL_ROUTING_EXISTS = "ROUTING_EXISTS";
	
	public static final String COL_FAULT_CODE = "FAULT_CODE";
	public static final String COL_FAULT_DESC = "FAULT_DESC";
	
	private String taskSource;
	private String userId;
	private String creator; 
	private Date dueDate;
	private String externalTaskId;
	private String uteTaskId;
	private String errorCode;
	private String errorDescription;
	private Date createdDate;
	private Date updatedDate;
	private String faultCode;
	private String faultDesc;
	
	private String action;
	private String status;
	private String outcome;
	private String title;
	private Boolean routingExists;
	private String routingComponentName;
	private String routingComponentId;

	private String assignee;
	private String workGroup;
	private String workPool;
	
	private OrderInfo orderInfo;
	
	
	
	private Map<String, String> taskAttributes;
	private Map<String, String> routingAttributes;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUteTaskId() {
		return uteTaskId;
	}
	public void setUteTaskId(String uteTaskId) {
		this.uteTaskId = uteTaskId;
	}
	public String getAction() {
		return action;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public String getCreator() {
		return creator;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public String getExternalTaskId() {
		return externalTaskId;
	}
	public OrderInfo getOrderInfo() {
		return orderInfo;
	}
	public String getOutcome() {
		return outcome;
	}
	public Map<String, String> getRoutingAttributes() {
		return routingAttributes;
	}
	public String getRoutingComponentId() {
		return routingComponentId;
	}
	public String getRoutingComponentName() {
		return routingComponentName;
	}
	public Boolean getRoutingExists() {
		return routingExists;
	}
	public Map<String, String> getTaskAttributes() {
		return taskAttributes;
	}
	public String getTaskSource() {
		return taskSource;
	}
	public String getTitle() {
		return title;
	}
	public String getUserId() {
		return userId;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public void setExternalTaskId(String externalTaskId) {
		this.externalTaskId = externalTaskId;
	}
	
	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public void setRoutingAttributes(Map<String, String> routingAttributes) {
		this.routingAttributes = routingAttributes;
	}
	public void setRoutingComponentId(String routingComponentId) {
		this.routingComponentId = routingComponentId;
	}
	
	public void setRoutingComponentName(String routingComponentName) {
		this.routingComponentName = routingComponentName;
	}
	public void setRoutingExists(Boolean routingExists) {
		this.routingExists = routingExists;
	}
	public void setTaskAttributes(Map<String, String> taskAttributes) {
		this.taskAttributes = taskAttributes;
	}
	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getWorkGroup() {
		return workGroup;
	}
	public void setWorkGroup(String workGroup) {
		this.workGroup = workGroup;
	}
	public String getWorkPool() {
		return workPool;
	}
	public void setWorkPool(String workPool) {
		this.workPool = workPool;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TaskRequest [taskSource=");
		builder.append(taskSource);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", creator=");
		builder.append(creator);
		builder.append(", dueDate=");
		builder.append(dueDate);
		builder.append(", externalTaskId=");
		builder.append(externalTaskId);
		builder.append(", uteTaskId=");
		builder.append(uteTaskId);
		builder.append(", errorCode=");
		builder.append(errorCode);
		builder.append(", errorDescription=");
		builder.append(errorDescription);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", faultCode=");
		builder.append(faultCode);
		builder.append(", faultDesc=");
		builder.append(faultDesc);
		builder.append(", action=");
		builder.append(action);
		builder.append(", status=");
		builder.append(status);
		builder.append(", outcome=");
		builder.append(outcome);
		builder.append(", title=");
		builder.append(title);
		builder.append(", routingExists=");
		builder.append(routingExists);
		builder.append(", routingComponentName=");
		builder.append(routingComponentName);
		builder.append(", routingComponentId=");
		builder.append(routingComponentId);
		builder.append(", assignee=");
		builder.append(assignee);
		builder.append(", workGroup=");
		builder.append(workGroup);
		builder.append(", workPool=");
		builder.append(workPool);
		builder.append(", orderInfo=");
		builder.append(orderInfo);
		builder.append(", taskAttributes=");
		builder.append(taskAttributes);
		builder.append(", routingAttributes=");
		builder.append(routingAttributes);
		builder.append("]");
		return builder.toString();
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	public String getFaultDesc() {
		return faultDesc;
	}
	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}
	
	
}
