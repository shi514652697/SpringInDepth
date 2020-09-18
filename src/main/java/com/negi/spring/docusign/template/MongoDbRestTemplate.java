package com.negi.spring.docusign.template;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.negi.spring.docusign.model.EsignTransactionDto;
import com.negi.spring.docusign.model.SignatureRequest;
import com.negi.spring.docusign.model.SignatureResponse;
import com.negi.spring.docusign.utils.RestConnectionUtil;

@Service
public class MongoDbRestTemplate {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("ONG-C-OnBoardingMongoDB-UsRetail")
	private String onboardingMongoDBService;
	
	@Autowired
	RestConnectionUtil restConnectUtil;

	@Async
	public String saveEsignTransaction(String uuid, String businessCode, String countryCode, String channelid,
			EsignTransactionDto esignTransaction) {
				
		String response = null;
		
		URI serviceURI = null;
		String docusignId="234";
		Map<String, String> paramMap= new HashMap<>();
		
		paramMap.put("docusignId", docusignId);
	
		 serviceURI = restConnectUtil.getURI(onboardingMongoDBService, "/esign/accounts/save/esignTransaction");
		
		HttpEntity<EsignTransactionDto> requestEntity = new HttpEntity<>(esignTransaction, 
				restConnectUtil.getHttpHeaders(uuid,"GCB","US","ESIGN",docusignId));
		
		if(serviceURI != null)
		{
			ResponseEntity<String> result = restTemplate.exchange(serviceURI.toString(), HttpMethod.POST, requestEntity, String.class);
			response = result.getBody();
		}
		
		return response;
		
	}
	
	

}
