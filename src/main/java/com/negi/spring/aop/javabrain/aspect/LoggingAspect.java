package com.negi.spring.aop.aspect.javabrain.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	//Advice to apply all getName
	@Before("execution(public String getName())")
	public void LoggingAdvice()
	{
		System.out.println("Advice Run Get method called");
	}
	
	//Advice to Aply to Circle class getName only
	@Before("execution(public String com.negi.spring.aop.aspect.javabrain.model.Circle.getName())")
	public void LoggingAdvice2()
	{
		System.out.println("Advice Run Get method called");
	}
	
	// Apply to all function start with get
	@Before("execution(public String * get*())")
	public void LoggingAdvice3()
	{
		System.out.println("Advice Run Get method called");
	}
	
	//apply to get with parameter
	@Before("execution(public String * get*(*))")
	public void LoggingAdvice4()
	{
		System.out.println("Advice Run Get method called");
	}
	
	//Apply to get with multiple parameters
	@Before("execution(public String * get*(..))")
	public void LoggingAdvice5()
	{
		System.out.println("Advice Run Get method called");
	}

}
