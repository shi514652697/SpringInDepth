package com.negi.spring.docusign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.negi.spring.docusign.model.EsignTransactionDto;
import com.negi.spring.docusign.model.SignatureRequest;
import com.negi.spring.docusign.model.SignatureResponse;
import com.negi.spring.docusign.model.SubmitDocumentRequest;
import com.negi.spring.docusign.model.SubmitDocumentResponse;
import com.negi.spring.docusign.template.MongoDbRestTemplate;

@Service
public class InpersonSignerService {
	
	@Autowired
	EsignRestService esignRestService;
	
	@Autowired
	MongoDbRestTemplate mongoCrudService;

	
	public SubmitDocumentResponse submitDocusign(String uuid,String businessCode, String countryCode,
			String channelid,String applicationId,SubmitDocumentRequest submitDocusignRequest)
	{
		SubmitDocumentResponse subbmitDocumentResponse = new SubmitDocumentResponse();
		
		SignatureRequest signatureRequest= new SignatureRequest();
		SignatureResponse response = esignRestService.getSignatureResponse(uuid,submitDocusignRequest,signatureRequest);
		EsignTransactionDto esignTransaction= new EsignTransactionDto();
		mongoCrudService.saveEsignTransaction(uuid,businessCode,countryCode,channelid,esignTransaction);
		
		return subbmitDocumentResponse;
		
	}
	
	
}
