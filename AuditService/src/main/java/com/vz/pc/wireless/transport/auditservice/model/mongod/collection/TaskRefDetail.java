package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;


import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author PEACJA7
 *
 */
@Document(collection = "taskrefdetail")
public class TaskRefDetail {

	@Id
	private long id;
	
	private String taskname;
	
	private String actualTaskName;

	public String getActualTaskName() {
		return actualTaskName;
	}

	public void setActualTaskName(String actualTaskName) {
		this.actualTaskName = actualTaskName;
	}

	private String prevtask;
	
	private String nexttask;

	private DateTime createTime;
	
	private long timeoutinms;
	
	private long sequence;
	
	private String higherlevelfield;
		
	private boolean istimeoutreq;
	
	public String getPrevtask() {
		return prevtask;
	}

	public void setPrevtask(String prevtask) {
		this.prevtask = prevtask;
	}

	public String getHigherlevelfield() {
		return higherlevelfield;
	}

	public void setHigherlevelfield(String higherlevelfield) {
		this.higherlevelfield = higherlevelfield;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getNexttask() {
		return nexttask;
	}

	public void setNexttask(String nexttask) {
		this.nexttask = nexttask;
	}

	public DateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}

	public long getTimeoutinms() {
		return timeoutinms;
	}

	public void setTimeoutinms(long timeoutinms) {
		this.timeoutinms = timeoutinms;
	}

	public long getSequence() {
		return sequence;
	}

	public void setSequence(long sequence) {
		this.sequence = sequence;
	}

	public boolean isIstimeoutreq() {
		return istimeoutreq;
	}

	public void setIstimeoutreq(boolean istimeoutreq) {
		this.istimeoutreq = istimeoutreq;
	}

	@Override
	public String toString() {
		return "TaskRefDetail [id=" + id + ", taskname=" + taskname + ", nexttask=" + nexttask + ", createTime=" + createTime + ", timeoutinms=" + timeoutinms
				+ ", sequence=" + sequence + ", istimeoutreq=" + istimeoutreq + "]";
	}

		
}
