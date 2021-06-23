package com.negi.spring.aop.aspect.javabrain.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Trangle {
	
	private String name= "Triangle";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@PostConstruct
	public void init ()
	{
		name= "Triangle";
	}
}
