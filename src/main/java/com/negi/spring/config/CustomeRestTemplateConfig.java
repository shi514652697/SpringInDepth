package com.negi.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomeRestTemplateConfig {
	
	@Value("${cert.certpath")
	private String certPath;
	
	@Value("${cert.store}")
	private String keyStoreFile;
	
	@Value("${cert.password}")
	private String keyStorePassword;
	


	

}
