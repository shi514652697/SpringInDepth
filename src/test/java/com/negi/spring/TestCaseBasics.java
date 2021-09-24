package com.negi.spring;

import static org.mockito.Mockito.lenient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class TestCaseBasics {
	
	//@InjectMocks
	//@Mock
	
	@BeforeEach
	public void setup()
	{
		String text= null;
		MockitoAnnotations.initMocks(this);
		//ReflectionTestUtils.setField(className, variable, varaibleVal);
		//lenient().when(service.get(ArgumentMatchers.any())).thenReturn(stubbedObj)
		
		Assertions.assertThrows(Exception.class, ()->text.toString());
		//Assertions.assertNotNull(service.getMethod());
		
		//lenient().doNothing().when(repo).deteteItems();
	}

}
