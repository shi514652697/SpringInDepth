package com.negi.spring.docusign.model;

public class SignatureResponse {
	
	private String requestIdentifier;
	private String envelopIdentifier;
	private String responseMessage;
	public String getRequestIdentifier() {
		return requestIdentifier;
	}
	public void setRequestIdentifier(String requestIdentifier) {
		this.requestIdentifier = requestIdentifier;
	}
	public String getEnvelopIdentifier() {
		return envelopIdentifier;
	}
	public void setEnvelopIdentifier(String envelopIdentifier) {
		this.envelopIdentifier = envelopIdentifier;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	

}
