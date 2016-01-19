package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection ="TaskTemplate")
public class TaskTemplate {

	@Id
	private long id;
	
	private long sequence;
	
	private String templateType;
	
	private String taskName;
	
	private String milestoneEvent;
	
	private String timeForTask;
	
	private String previousTask;
	
	private String nextTask;
	
	private long expectedTimeOutForNextTask;
	
	private String preCheck;
	
	private String postCheck;
	
	
	private int toggle;
	
	
	public int getToggle() {
		return toggle;
	}

	public void setToggle(int toggle) {
		this.toggle = toggle;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getMilestoneEvent() {
		return milestoneEvent;
	}

	public void setMilestoneEvent(String milestoneEvent) {
		this.milestoneEvent = milestoneEvent;
	}

	public String getTimeForTask() {
		return timeForTask;
	}

	public void setTimeForTask(String timeForTask) {
		this.timeForTask = timeForTask;
	}

	public String getPreviousTask() {
		return previousTask;
	}

	public void setPreviousTask(String previousTask) {
		this.previousTask = previousTask;
	}

	public String getNextTask() {
		return nextTask;
	}

	public void setNextTask(String nextTask) {
		this.nextTask = nextTask;
	}

	public long getExpectedTimeOutForNextTask() {
		return expectedTimeOutForNextTask;
	}

	public void setExpectedTimeOutForNextTask(long expectedTimeOutForNextTask) {
		this.expectedTimeOutForNextTask = expectedTimeOutForNextTask;
	}

	public String getPreCheck() {
		return preCheck;
	}

	public void setPreCheck(String preCheck) {
		this.preCheck = preCheck;
	}

	public String getPostCheck() {
		return postCheck;
	}

	public void setPostCheck(String postCheck) {
		this.postCheck = postCheck;
	}

	@Override
	public String toString() {
		return "TaskTemplate [id=" + id + ", sequence=" + sequence + ", templateType=" + templateType + ", taskName=" + taskName + ", milestoneEvent="
				+ milestoneEvent + ", timeForTask=" + timeForTask + ", previousTask=" + previousTask + ", nextTask=" + nextTask
				+ ", expectedTimeOutForNextTask=" + expectedTimeOutForNextTask + ", preCheck=" + preCheck + ", postCheck=" + postCheck + ", toggle=" + toggle
				+ "]";
	}


	
	
}
