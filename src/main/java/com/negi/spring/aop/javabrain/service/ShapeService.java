package com.negi.spring.aop.javabrain.service;

import org.springframework.stereotype.Service;

import com.negi.spring.aop.javabrain.model.Circle;
import com.negi.spring.aop.javabrain.model.Trangle;


@Service
public class ShapeService {
	
	private Circle circle;
	private Trangle trangle;
	
	public ShapeService(Trangle trangle) {
		this.trangle = trangle;
	}
	
	public ShapeService(Circle circle) {
		this.circle = circle;
	}
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Trangle getTrangle() {
		return trangle;
	}
	public void setTrangle(Trangle trangle) {
		this.trangle = trangle;
	}
	

}
