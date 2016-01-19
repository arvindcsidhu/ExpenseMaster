package com.vz.pc.wireless.transport.auditservice.model;

public class PcWirelessRemarkRequest {
	
	
	private Long NotesRemarksId;
	private Long pcOrderId;
	private String NotesRemarksText;
	private String modifiedBy;
	private String modifiedDate;
	private String taskName;
	private String strikeFlag;
	public Long getNotesRemarksId() {
		return NotesRemarksId;
	}
	public void setNotesRemarksId(Long notesRemarksId) {
		NotesRemarksId = notesRemarksId;
	}
	public Long getPcOrderId() {
		return pcOrderId;
	}
	public void setPcOrderId(Long pcOrderId) {
		this.pcOrderId = pcOrderId;
	}
	public String getNotesRemarksText() {
		return NotesRemarksText;
	}
	public void setNotesRemarksText(String notesRemarksText) {
		NotesRemarksText = notesRemarksText;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getStrikeFlag() {
		return strikeFlag;
	}
	public void setStrikeFlag(String strikeFlag) {
		this.strikeFlag = strikeFlag;
	}

}
