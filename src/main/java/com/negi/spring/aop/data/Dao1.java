package com.negi.spring.aop.data;

import org.springframework.stereotype.Repository;

import com.negi.spring.aop.aspect.TrackTime;


@Repository
public class Dao1 {
	
	@TrackTime
	public String retrieveSomething(){
		return "Dao1";
	}

}
