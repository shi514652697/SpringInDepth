package com.negi.spring.aop.aspect.javabrain.model;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Circle {
	
	private String name= "Circle";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
