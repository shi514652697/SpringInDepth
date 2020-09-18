package com.negi.spring.docusign.model;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ApplicationCapture {
	
	@NotEmpty(message="Application Id cannot be empty")
	private String aplicationId;
	
	private String operatorId;

	public String getAplicationId() {
		return aplicationId;
	}

	public void setAplicationId(String aplicationId) {
		this.aplicationId = aplicationId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
	

}
