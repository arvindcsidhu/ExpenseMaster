package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pcWirelessOrder")
public class PcWirelessOrder {

	@Id
	private long id;

	private Order order;

	private OrderDetails orderDetails;
	
	private boolean isAsrCreated;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public boolean isAsrCreated() {
		return isAsrCreated;
	}

	public void setAsrCreated(boolean isAsrCreated) {
		this.isAsrCreated = isAsrCreated;
	}

}
