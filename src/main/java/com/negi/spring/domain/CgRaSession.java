package com.negi.spring.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="CG_RA_SESSION")
public class CgRaSession implements Serializable{

	private static final long serialVersionUID = -7267388361950162072L;
	
	@Id
	@Column(name="CG_RA_SESSION_ID")
	private String cgSessionId;

	@Column(name="CG_BRANCH")
	private String branchText;
	
	@Column(name="CG_CUST_TYPE")
	private String customerType;
	
	@Column(name="CG_OPR_ID")
	private String operatorId;
	
	@Column(name="CG_USER_ROLE")
	private String userRole;

	public String getCgSessionId() {
		return cgSessionId;
	}

	public void setCgSessionId(String cgSessionId) {
		this.cgSessionId = cgSessionId;
	}

	public String getBranchText() {
		return branchText;
	}

	public void setBranchText(String branchText) {
		this.branchText = branchText;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
