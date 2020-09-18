package com.negi.spring.docusign.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SubmitDocumentRequest {
	
	private List<SignerDetails> signerDetails;
	
	@Valid
	@NotNull
	private ApplicationCapture applicationCapture;
	
	@NotEmpty
	private String submitionType;
	
	private String deviceType;

	public List<SignerDetails> getSignerDetails() {
		return signerDetails;
	}

	public void setSignerDetails(List<SignerDetails> signerDetails) {
		this.signerDetails = signerDetails;
	}

	public ApplicationCapture getApplicationCapture() {
		return applicationCapture;
	}

	public void setApplicationCapture(ApplicationCapture applicationCapture) {
		this.applicationCapture = applicationCapture;
	}

	public String getSubmitionType() {
		return submitionType;
	}

	public void setSubmitionType(String submitionType) {
		this.submitionType = submitionType;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	
	

}
