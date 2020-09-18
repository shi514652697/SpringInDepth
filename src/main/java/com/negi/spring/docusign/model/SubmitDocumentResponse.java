package com.negi.spring.docusign.model;

public class SubmitDocumentResponse {
	
	private SignatureResponse signatureResponse;
	private boolean statusFlag;
	private String responseMessage;
	public SignatureResponse getSignatureResponse() {
		return signatureResponse;
	}
	public void setSignatureResponse(SignatureResponse signatureResponse) {
		this.signatureResponse = signatureResponse;
	}
	public boolean isStatusFlag() {
		return statusFlag;
	}
	public void setStatusFlag(boolean statusFlag) {
		this.statusFlag = statusFlag;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
	

}
