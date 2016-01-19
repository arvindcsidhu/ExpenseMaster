package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;

import java.util.Date;

public class Order {

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderVersion=" + orderVersion + ", orderSource=" + orderSource + ", workId=" + workId + ", orderStatus=" + orderStatus
				+ ", createdTime=" + createdTime + ", lastUpdatedTime=" + lastUpdatedTime + "]";
	}

	private String orderNumber;
	
	private String orderVersion;
	
	private int orderSource;
	
	private long workId;
	
	private String orderStatus;
	
	private Date createdTime;
	
	private Date lastUpdatedTime;

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

	public int getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(int vzw) {
		this.orderSource = vzw;
	}

	public long getWorkId() {
		return workId;
	}

	
	public void setWorkId(long workId) {
		this.workId = workId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date l) {
		this.createdTime = l;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	
	
}
