package com.negi.spring.docusign.template;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.negi.spring.docusign.model.SignatureRequest;
import com.negi.spring.docusign.model.SignatureResponse;
import com.negi.spring.docusign.utils.RestConnectionUtil;

@Component
public class EsignRestTemplate {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RestConnectionUtil restConnectUtil;
	
	@Value("XLG-DM-D-CREATEENV-ESIGN")
	String createEsignUrl;
	
	@Value("${esign.url.esignurl: https://www.esign.com}")
	String eisgnUrl;

	public SignatureResponse callEsign(String uuid, String aplicationId, SignatureRequest signatureRequest) {
		URI serviceURI = null;
		String docusignId="234";
		Map<String, String> paramMap= new HashMap<>();
		
		paramMap.put("docusignId", docusignId);
		
		SignatureResponse response= new SignatureResponse();
		 serviceURI = restConnectUtil.getPramsURI(createEsignUrl, "/esign/accounts/{docusignId}/envelope", paramMap);
		
		HttpEntity<SignatureRequest> requestEntity = new HttpEntity<>(signatureRequest, 
				restConnectUtil.getHttpHeaders(uuid,"GCB","US","ESIGN",docusignId));
		
		if(serviceURI != null)
		{
			ResponseEntity<SignatureResponse> result = restTemplate.exchange(serviceURI.toString(), HttpMethod.POST, requestEntity, SignatureResponse.class);
			response = result.getBody();
		}
		
		return response;
	}

}
