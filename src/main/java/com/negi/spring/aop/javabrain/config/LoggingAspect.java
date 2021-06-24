package com.negi.spring.aop.javabrain.config;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

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
	
	@Before("execution(public String * get*(..))")
	public void secondAdvice()
	{
		System.out.println("Second Advice Executed");
	}
	
	@Pointcut("execution(* set*()")
	public void allSetters()
	{
		
	}
	
	@Before("allSetters()")
	public void usingPointCut()
	{
		System.out.println("Advice to before all setters");
	}
	
	
	@Pointcut("execution(* * com.negi.spring.aop.aspect.javabrain.model.Circle.*(..))")
	public void allCircleMethods()
	{
		
	}
	
	//Within Circle class
	@Pointcut("within(com.negi.spring.aop.aspect.javabrain.model.Circle)")
	public void allCircleMethods1()
	{
		
	}
	
	//Within model and sub packages
	@Pointcut("within(com.negi.spring.aop.aspect.javabrain.model..*)")
	public void allCircleMethods2()
		{
			
		}
	
	//combining multiple pointcuts
	@Before("allSetters() && allCircleMethods1()")
	public void usingPointCut2()
	{
		System.out.println("Advice to before all setters");
	}
	
	//jointpoint to print information about methods
	@Before("allSetters()")
	public void usingPointCut5(JoinPoint joinpoint)
	{
		System.out.println(joinpoint.getTarget());
	}
	
	//jmethod takes String arg has been called
	@Before("args(String)")
	public void stringArgMethod(String name)
	{
		System.out.println("argument"+ name);
	}
	
	
	@After("args(name)")
	public void calledAfterMethod(String name)
	{
		System.out.println("advice called after String arg method executed");
	}
	
	
	@AfterReturning("args(name)")
	public void calledAfterMethodReturn(String name)
	{
		System.out.println("advice called after String arg method return success");
	}
	
	@AfterThrowing("args(name)")
	public void calledAfterMethodThroException(String name)
	{
		System.out.println("advice called after String arg method return error or throw error");
	}
	
	
	@AfterReturning(pointcut="args(name)", returning ="returningString")
	public void calledAfterMethodReturn1(String name,String returningString)
	{
		System.out.println("advice called after String arg method return success with return value"+ returningString +"and arg value is "+ name);
	}
	
	
	@AfterThrowing(pointcut="args(name)", throwing = "ex")
	public void calledAfterMethodThroException1(String name, RuntimeException ex)
	{
		System.out.println("advice called after String arg method return error or throw error and exception thrown is"+ ex);
	}
	
	
	@Around("allSetters()")
	public Object myAroundAdvice(ProceedingJoinPoint pjointpoint)
	{
		Object returnValue= null;
		try {
			System.out.println("before execution of method");
			returnValue = pjointpoint.proceed();
			System.out.println("after returning success");
		} catch (Throwable e) {
			System.out.println("after throwing error");
			e.printStackTrace();
		}
		
		return returnValue;
	}
	
	
}
