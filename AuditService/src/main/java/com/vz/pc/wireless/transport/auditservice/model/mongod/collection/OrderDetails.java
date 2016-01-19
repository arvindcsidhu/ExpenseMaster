package com.vz.pc.wireless.transport.auditservice.model.mongod.collection;

import java.util.Date;

public class OrderDetails {

	private String orderType;
	
	private Date customerDesiredDueDate;
	
	private String projectId;
	
	private String region;
	
	private String domain;
	
	private String serviceType;
	
	private String productCategory;
	
	private String productSubCategory;
	
	private String changeReasion;
	
	private String cno;
	
	private String userId;
	
	private String actlCoLocation;
	
	private String acna;
	
	private String ccna;
	
	private String actl;
	
	private String tspCode;
	
	private String spec;
	
	private String pon;
	
	private String relatedPon;
	
	private String copyPon;
	
	private String disconnectPon;
	
	private String disconnectCopyPon;
	
	private String asog;
	
	private String evcSP;
	
	private String hotcut;
	
	private String expedite;
	
	private String multiEC;
	
	private String duplicateSegments;
	
	private String cktRows;
	
	private Segment segments[];
	
	private Site sites[];



	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public Date getCustomerDesiredDueDate() {
		return customerDesiredDueDate;
	}

	public void setCustomerDesiredDueDate(Date date) {
		this.customerDesiredDueDate = date;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public String getChangeReasion() {
		return changeReasion;
	}

	public void setChangeReasion(String changeReasion) {
		this.changeReasion = changeReasion;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getActlCoLocation() {
		return actlCoLocation;
	}

	public void setActlCoLocation(String actlCoLocation) {
		this.actlCoLocation = actlCoLocation;
	}

	public String getAcna() {
		return acna;
	}

	public void setAcna(String acna) {
		this.acna = acna;
	}

	public String getCcna() {
		return ccna;
	}

	public void setCcna(String ccna) {
		this.ccna = ccna;
	}

	public String getActl() {
		return actl;
	}

	public void setActl(String actl) {
		this.actl = actl;
	}

	public String getTspCode() {
		return tspCode;
	}

	public void setTspCode(String tspCode) {
		this.tspCode = tspCode;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getPon() {
		return pon;
	}

	public void setPon(String pon) {
		this.pon = pon;
	}

	public String getRelatedPon() {
		return relatedPon;
	}

	public void setRelatedPon(String relatedPon) {
		this.relatedPon = relatedPon;
	}

	public String getCopyPon() {
		return copyPon;
	}

	public void setCopyPon(String copyPon) {
		this.copyPon = copyPon;
	}

	public String getDisconnectPon() {
		return disconnectPon;
	}

	public void setDisconnectPon(String disconnectPon) {
		this.disconnectPon = disconnectPon;
	}

	public String getDisconnectCopyPon() {
		return disconnectCopyPon;
	}

	public void setDisconnectCopyPon(String disconnectCopyPon) {
		this.disconnectCopyPon = disconnectCopyPon;
	}

	public String getAsog() {
		return asog;
	}

	public void setAsog(String asog) {
		this.asog = asog;
	}

	public String getEvcSP() {
		return evcSP;
	}

	public void setEvcSP(String evcSP) {
		this.evcSP = evcSP;
	}

	public String getHotcut() {
		return hotcut;
	}

	public void setHotcut(String hotcut) {
		this.hotcut = hotcut;
	}

	public String getExpedite() {
		return expedite;
	}

	public void setExpedite(String expedite) {
		this.expedite = expedite;
	}

	public String getMultiEC() {
		return multiEC;
	}

	public void setMultiEC(String multiEC) {
		this.multiEC = multiEC;
	}

	public String getDuplicateSegments() {
		return duplicateSegments;
	}

	public void setDuplicateSegments(String duplicateSegments) {
		this.duplicateSegments = duplicateSegments;
	}

	public String getCktRows() {
		return cktRows;
	}

	public void setCktRows(String cktRows) {
		this.cktRows = cktRows;
	}

	public Segment[] getSegments() {
		return segments;
	}

	public void setSegments(Segment[] segments) {
		this.segments = segments;
	}

	public Site[] getSites() {
		return sites;
	}

	public void setSites(Site[] sites) {
		this.sites = sites;
	}
	
	
	
	
	
}
