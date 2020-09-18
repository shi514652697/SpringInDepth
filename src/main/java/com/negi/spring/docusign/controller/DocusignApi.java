package com.negi.spring.docusign.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.negi.spring.docusign.model.SubmitDocumentRequest;
import com.negi.spring.docusign.model.SubmitDocumentResponse;

public interface DocusignApi {
	
	@PostMapping(value="retail/docusign/envelope/submit", produces= {"application/json"})
	ResponseEntity<SubmitDocumentResponse> docusignSubmit(
			@RequestHeader(value="client_id", required= false) String clientId,
			@RequestHeader(value="Authorization", required= false) String authorization,
			@RequestHeader(value="Accept", required= false) String acceptLanguage,
			@RequestHeader(value="uuid", required= false) String uuid,
			@RequestHeader(value="businessCode", required= false, defaultValue="GCB") String businessCode,
			@RequestHeader(value="countryCode", required= false, defaultValue="US") String countryCode,
			@RequestHeader(value="channelId", required= false, defaultValue="RTLAO") String channelId,
			@RequestBody @Valid SubmitDocumentRequest submitDocumentRequest);
	
	

}
