package com.verizon.ginger.utewrapper.valueobject;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "OrderInfo")
@XmlType(namespace = "http://utewrapper.verizon.com")
public class OrderInfo {
	
	public static final String COL_CDDD = "CDDD";
	public static final String COL_CIRCUIT_ID = "CIRCUIT_ID";
	public static final String COL_CUSTOMER_NAME ="CUSTOMER_NAME";
	public static final String COL_INTERNAL_WO_NUMBER = "INTERNAL_WO_NUMBER";
	public static final String COL_LOB = "LOB";
	public static final String COL_ORDER_DUE_DATE = "ORDER_DUE_DATE";
	public static final String COL_ORDER_SOURCE = "ORDER_SOURCE";
	public static final String COL_ORDER_TYPE = "ORDER_TYPE";
	public static final String COL_ORDER_VERSION = "ORDER_VERSION";
	public static final String COL_PRODUCT = "PRODUCT";
	public static final String COL_RELATED_ORDER = "RELATED_ORDER";
	public static final String COL_SERVICE_ORDER_NUMBER = "SERVICE_ORDER_NUMBER";
	public static final String COL_SUB_PRODUCT = "SUB_PRODUCT";
	public static final String COL_WORK_ORDER_NUMBER = "WORK_ORDER_NUMBER";

	private String customerName;
	private String serviceOrderNumber;
	private String workOrderNumber;
	private String internalWorkOrderNumber;
	private String relatedOrder;
	private String orderVersion;
	private String orderType;
	private String orderSource;
	private Date orderDueDate;
	private Date CDDD;
	private String lineOfBusiness;
	private String product;
	private String subProduct;
	private String circuitID;
	
	public Date getCDDD() {
		return CDDD;
	}
	public String getCircuitID() {
		return circuitID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getInternalWorkOrderNumber() {
		return internalWorkOrderNumber;
	}
	public String getLineOfBusiness() {
		return lineOfBusiness;
	}
	public Date getOrderDueDate() {
		return orderDueDate;
	}
	public String getOrderSource() {
		return orderSource;
	}
	public String getOrderType() {
		return orderType;
	}
	public String getOrderVersion() {
		return orderVersion;
	}
	public String getProduct() {
		return product;
	}
	public String getRelatedOrder() {
		return relatedOrder;
	}
	public String getServiceOrderNumber() {
		return serviceOrderNumber;
	}
	public String getSubProduct() {
		return subProduct;
	}
	public String getWorkOrderNumber() {
		return workOrderNumber;
	}
	public void setCDDD(Date cDDD) {
		CDDD = cDDD;
	}
	public void setCircuitID(String circuitID) {
		this.circuitID = circuitID;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setInternalWorkOrderNumber(String internalWorkOrderNumber) {
		this.internalWorkOrderNumber = internalWorkOrderNumber;
	}
	public void setLineOfBusiness(String lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public void setOrderDueDate(Date orderDueDate) {
		this.orderDueDate = orderDueDate;
	}
	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public void setOrderVersion(String orderVersion) {
		this.orderVersion = orderVersion;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public void setRelatedOrder(String relatedOrder) {
		this.relatedOrder = relatedOrder;
	}
	public void setServiceOrderNumber(String serviceOrderNumber) {
		this.serviceOrderNumber = serviceOrderNumber;
	}
	public void setSubProduct(String subProduct) {
		this.subProduct = subProduct;
	}
	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderInfo [customerName=");
		builder.append(customerName);
		builder.append(", serviceOrderNumber=");
		builder.append(serviceOrderNumber);
		builder.append(", workOrderNumber=");
		builder.append(workOrderNumber);
		builder.append(", internalWorkOrderNumber=");
		builder.append(internalWorkOrderNumber);
		builder.append(", relatedOrder=");
		builder.append(relatedOrder);
		builder.append(", orderVersion=");
		builder.append(orderVersion);
		builder.append(", orderType=");
		builder.append(orderType);
		builder.append(", orderSource=");
		builder.append(orderSource);
		builder.append(", orderDueDate=");
		builder.append(orderDueDate);
		builder.append(", CDDD=");
		builder.append(CDDD);
		builder.append(", lineOfBusiness=");
		builder.append(lineOfBusiness);
		builder.append(", product=");
		builder.append(product);
		builder.append(", subProduct=");
		builder.append(subProduct);
		builder.append(", circuitID=");
		builder.append(circuitID);
		builder.append("]");
		return builder.toString();
	}
}
