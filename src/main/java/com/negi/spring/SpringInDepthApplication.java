package com.negi.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.negi.spring.aop.business.Business1;
import com.negi.spring.aop.business.Business2;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringInDepthApplication implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(SpringInDepthApplication.class);
	
	@Autowired
	Business1 business1;
	
	@Autowired
	Business2 business2;

	public static void main(String[] args) {
		SpringApplication.run(SpringInDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("****************");
		LOG.info("******  " +business1.calculateSomething());
		business2.calculateSomething();
	}

}
