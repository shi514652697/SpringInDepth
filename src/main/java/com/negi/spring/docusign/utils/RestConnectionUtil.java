package com.negi.spring.docusign.utils;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class RestConnectionUtil {
	
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Value("#{null)")
	private Random random;
	
	public URI getURI(String serviceName, String endPoint) {
		String serviceUrl = getServiceUrl(serviceName);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceUrl+ endPoint);
		URI uri = builder.build().encode().toUri();
		
		return uri;
	}
	
	
	public URI getPramsURI(String serviceName, String endPoint,Map<String,String> paramMap) {
		String serviceUrl = getServiceUrl(serviceName);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceUrl+ endPoint);
		URI uri = builder.buildAndExpand(paramMap).encode().toUri();
		
		return uri;
	}
	

	public String getServiceUrl(String serviceName) {
		String serviceUrl = "";
		if("activeProfile".contains("LOCAL"))
		{
			if(serviceName.equals("COUPON-SERVICE"))
			{
				serviceUrl = "http://localhost:8080";
			}
		}
		else
		{
			List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
			if(null != instances)
			{
				ServiceInstance instance = instances.get(random.nextInt(instances.size()));
				if(null != instance)
					return instance.getUri().toString();
			}
			
		}
		return null;
	}


	public HttpHeaders getHttpHeaders(String uuid, String businessCode, String countryCode, String channelId, String clientId) {
		
		MultiValueMap<String, String> args = new LinkedMultiValueMap<>();
		args.add("uuid", uuid);
		args.add("businessCode", businessCode);
		args.add("countryCode", countryCode);
		args.add("channelId", channelId);
		args.add("clientId", clientId);
		return new HttpHeaders(args);
		
	}

}
