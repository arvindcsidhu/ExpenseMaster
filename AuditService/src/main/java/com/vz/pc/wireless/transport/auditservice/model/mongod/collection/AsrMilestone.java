package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author PEACJA7
 *
 */
@Document(collection = "asrmilestone")
public class AsrMilestone {

	@Id
	private long id;
	
	private String orderNumber;

	private String orderVersion;

	private String pon;

	private String ponVersion;

	private String icsc;

	private String circuitId;

	private String cSite;

	private Date lecDesiredDueDate;

	private Date asrSendDate;

	private Date ackReceivedDate;

	private Date focReceivedDate;

	private String focUnsolicited;

	private Date focDate;

	private Date  cnrReceivedDate;

	private Date dlrReceivedDate;

	private String lecExpedite;

	private Date lastUpdated;

	private String cnrCode;

	private String lecAckStatus;

	private String asrType;

	private Timestamp createdTime;

	private long pcSubworkSeed;

	private String etherEvcASR;

	private String vlan;

	private String otherEcs;

	private String ponDeleted;

	private String lecOrderNumber;

	private String dlrRemarks;

	private String ban;

	private Date ebd;

	private String rtr;

	private Date completedDate;

	private String completedString;
	
	private String contactName;
	
	private String actcLnc;
	
	private String actlLoc;
	
	private String actlNci;
	
	private String tranType;

	private boolean notifyGraniteReq;
	
	private long uteTaskId;
	
	
	public boolean isNotifyGraniteReq() {
		return notifyGraniteReq;
	}

	public void setNotifyGraniteReq(boolean notifyGraniteReq) {
		this.notifyGraniteReq = notifyGraniteReq;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderVersion() {
		return orderVersion;
	}

	public void setOrderVersion(String orderVersion) {
		this.orderVersion = orderVersion;
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

	public String getCircuitId() {
		return circuitId;
	}

	public void setCircuitId(String circuitId) {
		this.circuitId = circuitId;
	}

	public String getcSite() {
		return cSite;
	}

	public void setcSite(String cSite) {
		this.cSite = cSite;
	}

	public Date getLecDesiredDueDate() {
		return lecDesiredDueDate;
	}

	public void setLecDesiredDueDate(Date lecDesiredDueDate) {
		this.lecDesiredDueDate = lecDesiredDueDate;
	}

	public Date getAsrSendDate() {
		return asrSendDate;
	}

	public void setAsrSendDate(Date asrSendDate) {
		this.asrSendDate = asrSendDate;
	}

	public Date getAckReceivedDate() {
		return ackReceivedDate;
	}

	public void setAckReceivedDate(Date ackReceivedDate) {
		this.ackReceivedDate = ackReceivedDate;
	}

	public Date getFocReceivedDate() {
		return focReceivedDate;
	}

	public void setFocReceivedDate(Date focReceivedDate) {
		this.focReceivedDate = focReceivedDate;
	}

	public String getFocUnsolicited() {
		return focUnsolicited;
	}

	public void setFocUnsolicited(String focUnsolicited) {
		this.focUnsolicited = focUnsolicited;
	}

	public Date getFocDate() {
		return focDate;
	}

	public void setFocDate(Date focDate) {
		this.focDate = focDate;
	}

	public Date getCnrReceivedDate() {
		return cnrReceivedDate;
	}

	public void setCnrReceivedDate(Date cnrReceivedDate) {
		this.cnrReceivedDate = cnrReceivedDate;
	}

	public Date getDlrReceivedDate() {
		return dlrReceivedDate;
	}

	public void setDlrReceivedDate(Date dlrReceivedDate) {
		this.dlrReceivedDate = dlrReceivedDate;
	}

	public String getLecExpedite() {
		return lecExpedite;
	}

	public void setLecExpedite(String lecExpedite) {
		this.lecExpedite = lecExpedite;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getCnrCode() {
		return cnrCode;
	}

	public void setCnrCode(String cnrCode) {
		this.cnrCode = cnrCode;
	}

	public String getLecAckStatus() {
		return lecAckStatus;
	}

	public void setLecAckStatus(String lecAckStatus) {
		this.lecAckStatus = lecAckStatus;
	}

	public String getAsrType() {
		return asrType;
	}

	public void setAsrType(String asrType) {
		this.asrType = asrType;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public long getPcSubworkSeed() {
		return pcSubworkSeed;
	}

	public void setPcSubworkSeed(long pcSubworkSeed) {
		this.pcSubworkSeed = pcSubworkSeed;
	}

	public String getEtherEvcASR() {
		return etherEvcASR;
	}

	public void setEtherEvcASR(String etherEvcASR) {
		this.etherEvcASR = etherEvcASR;
	}

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	public String getOtherEcs() {
		return otherEcs;
	}

	public void setOtherEcs(String otherEcs) {
		this.otherEcs = otherEcs;
	}

	public String getPonDeleted() {
		return ponDeleted;
	}

	public void setPonDeleted(String ponDeleted) {
		this.ponDeleted = ponDeleted;
	}

	public String getLecOrderNumber() {
		return lecOrderNumber;
	}

	public void setLecOrderNumber(String lecOrderNumber) {
		this.lecOrderNumber = lecOrderNumber;
	}

	public String getDlrRemarks() {
		return dlrRemarks;
	}

	public void setDlrRemarks(String dlrRemarks) {
		this.dlrRemarks = dlrRemarks;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public Date getEbd() {
		return ebd;
	}

	public void setEbd(Date ebd) {
		this.ebd = ebd;
	}

	public String getRtr() {
		return rtr;
	}

	public void setRtr(String rtr) {
		this.rtr = rtr;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public String getCompletedString() {
		return completedString;
	}

	public void setCompletedString(String completedString) {
		this.completedString = completedString;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getActcLnc() {
		return actcLnc;
	}

	public void setActcLnc(String actcLnc) {
		this.actcLnc = actcLnc;
	}

	public String getActlLoc() {
		return actlLoc;
	}

	public void setActlLoc(String actlLoc) {
		this.actlLoc = actlLoc;
	}

	public String getActlNci() {
		return actlNci;
	}

	public void setActlNci(String actlNci) {
		this.actlNci = actlNci;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public long getUteTaskId() {
		return uteTaskId;
	}

	public void setUteTaskId(long uteTaskId) {
		this.uteTaskId = uteTaskId;
	}

	@Override
	public String toString() {
		return "AsrMilestone [id=" + id + ", orderNumber=" + orderNumber + ", orderVersion=" + orderVersion + ", pon=" + pon + ", ponVersion=" + ponVersion
				+ ", icsc=" + icsc + ", circuitId=" + circuitId + ", cSite=" + cSite + ", lecDesiredDueDate=" + lecDesiredDueDate + ", asrSendDate="
				+ asrSendDate + ", ackReceivedDate=" + ackReceivedDate + ", focReceivedDate=" + focReceivedDate + ", focUnsolicited=" + focUnsolicited
				+ ", focDate=" + focDate + ", cnrReceivedDate=" + cnrReceivedDate + ", dlrReceivedDate=" + dlrReceivedDate + ", lecExpedite=" + lecExpedite
				+ ", lastUpdated=" + lastUpdated + ", cnrCode=" + cnrCode + ", lecAckStatus=" + lecAckStatus + ", asrType=" + asrType + ", createdTime="
				+ createdTime + ", pcSubworkSeed=" + pcSubworkSeed + ", etherEvcASR=" + etherEvcASR + ", vlan=" + vlan + ", otherEcs=" + otherEcs
				+ ", ponDeleted=" + ponDeleted + ", lecOrderNumber=" + lecOrderNumber + ", dlrRemarks=" + dlrRemarks + ", ban=" + ban + ", ebd=" + ebd
				+ ", rtr=" + rtr + ", completedDate=" + completedDate + ", completedString=" + completedString + ", contactName=" + contactName + ", actcLnc="
				+ actcLnc + ", actlLoc=" + actlLoc + ", actlNci=" + actlNci + ", tranType=" + tranType + ", notifyGraniteReq=" + notifyGraniteReq + "]";
	}


	

	
	
	
	
}
