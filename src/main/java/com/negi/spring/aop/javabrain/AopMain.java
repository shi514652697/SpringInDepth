package com.negi.spring.aop.aspect.javabrain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.negi.spring.aop.aspect.javabrain.config.AspectConfig;
import com.negi.spring.aop.aspect.javabrain.model.Circle;
import com.negi.spring.aop.aspect.javabrain.model.Trangle;
import com.negi.spring.aop.aspect.javabrain.service.ShapeService;

//@Aspect
//@Configuration
public class AopMain {
	
	public static void main(String[] args) {
		ApplicationContext ct = new AnnotationConfigApplicationContext(AspectConfig.class);
		
		Circle  circle = ct.getBean(Circle.class);
		Trangle  triangle = ct.getBean(Trangle.class);
		System.out.println(new ShapeService(circle).getCircle().getName());
		System.out.println(new ShapeService(triangle).getTrangle().getName());
	}

}
