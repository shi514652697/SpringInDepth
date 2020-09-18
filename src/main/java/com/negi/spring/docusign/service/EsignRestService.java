package com.negi.spring.docusign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.negi.spring.docusign.model.SignatureRequest;
import com.negi.spring.docusign.model.SignatureResponse;
import com.negi.spring.docusign.model.SubmitDocumentRequest;
import com.negi.spring.docusign.template.EsignRestTemplate;

@Service
public class EsignRestService {
	
	@Autowired
	EsignRestTemplate esignRestTemplate;
	
	@Value("${esign.docusignId}")
	String docusignId;

	public SignatureResponse getSignatureResponse(String uuid, SubmitDocumentRequest submitDocusignRequest,
			SignatureRequest signatureRequest) {
		
		SignatureResponse response= null;
		
		response = esignRestTemplate.callEsign(uuid,submitDocusignRequest.getApplicationCapture().getAplicationId(),signatureRequest);
		return null;
		
		
	}

}
