package com.negi.spring.aop.aspect.javabrain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.negi.spring.aop.aspect.javabrain.aspect.LoggingAspect;
import com.negi.spring.aop.aspect.javabrain.model.Circle;
import com.negi.spring.aop.aspect.javabrain.model.Trangle;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
	
	@Bean
	public LoggingAspect aspect()
	{
		return new LoggingAspect();
	}
	
	@Bean
	public Circle getCircle()
	{
		return new Circle();
	}
	
	@Bean
	public Trangle getTrangle()
	{
		return new Trangle();
	}

}
