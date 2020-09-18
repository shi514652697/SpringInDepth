package com.negi.spring.docusign.service;

import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negi.spring.docusign.model.SubmitDocumentRequest;
import com.negi.spring.docusign.model.SubmitDocumentResponse;

@Service
public class SubmitDocusignService {
	
	
	@Autowired
	private InpersonSignerService inpersonSignerService;
	
	public SubmitDocumentResponse submitDocusign(String uuid,String businessCode, String countryCode,
			String channelid,SubmitDocumentRequest submitDocusignRequest)
	{
		SubmitDocumentResponse submitDocumentResponse = null;
		if(submitDocusignRequest.getSubmitionType().equals("INPERSON_SIGNER"))
				{
			     String enccodedApplicationId= Encode.forHtml(submitDocusignRequest.getApplicationCapture().getAplicationId());
			     submitDocumentResponse= inpersonSignerService.submitDocusign(uuid, businessCode, countryCode, channelid,
			    		 enccodedApplicationId, submitDocusignRequest);
				}
		
		return null;
		
	}

}
