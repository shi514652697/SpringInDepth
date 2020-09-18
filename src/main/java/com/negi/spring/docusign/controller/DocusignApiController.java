package com.negi.spring.docusign.controller;

import javax.validation.Valid;

import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.negi.spring.docusign.model.SubmitDocumentRequest;
import com.negi.spring.docusign.model.SubmitDocumentResponse;
import com.negi.spring.docusign.service.SubmitDocusignService;

@Controller
@EnableAutoConfiguration
public class DocusignApiController implements DocusignApi {
	
	@Autowired
	private SubmitDocusignService docusignService;

	@Override
	public ResponseEntity<SubmitDocumentResponse> docusignSubmit(String clientId, String authorization,
			String acceptLanguage, String uuid, String businessCode, String countryCode, String channelId,
			@Valid SubmitDocumentRequest submitDocumentRequest) {
		
		String encodeduuid = Encode.forHtml(uuid);
		String encodedBusinessCode= Encode.forHtml(businessCode);
		String encodedCountryCode= Encode.forHtml(countryCode);
		String encodedChannelId= Encode.forHtml(channelId);
		
		SubmitDocumentResponse submitDocumentResponse= docusignService.submitDocusign(encodeduuid, encodedBusinessCode, encodedCountryCode, encodedChannelId, submitDocumentRequest);
		return null;
	}

}
