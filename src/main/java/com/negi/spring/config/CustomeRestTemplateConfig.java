package com.negi.spring.config;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomeRestTemplateConfig {
	
	@Value("${cert.certpath")
	private String certPath;
	
	@Value("${cert.store}")
	private String keyStoreFile;
	
	@Value("${cert.password}")
	private String keyStorePassword;
	
	
	//general SSL connection
	@Bean(name="customRestTemplate")
	@Primary
	public RestTemplate restTemplate() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException
	{
		TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authYype) -> true;
		SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
		SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
		CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
		HttpComponentsClientHttpRequestFactory requestFact= new HttpComponentsClientHttpRequestFactory();
		requestFact.setHttpClient(httpClient);
		return new RestTemplate(requestFact);
	
		
	}
	

	

}
