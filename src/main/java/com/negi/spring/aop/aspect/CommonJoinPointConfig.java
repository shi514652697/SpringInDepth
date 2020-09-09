package com.negi.spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
	
	@Pointcut("execution(* com.negi.spring.aop.data.*.*(..))")
	public void dataLayerExecution(){}
	
	@Pointcut("execution(* com.negi.spring.aop.business.*.*(..))")
	public void businessLayerExecution(){}
	
	@Pointcut("dataLayerExecution() && businessLayerExecution()")
	public void allLayerExecution(){}
	
	@Pointcut("bean(*dao*)")
	public void beanContainingDao(){}
	
	@Pointcut("within(com.negi.spring.aop.data..*)")
	public void dataLayerExecutionWithWithin(){}

	@Pointcut("@annotation(com.negi.spring.aop.aspect.TrackTime)")
	public void trackTimeAnnotation(){}

}
