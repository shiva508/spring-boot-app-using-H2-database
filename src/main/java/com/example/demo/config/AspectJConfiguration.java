package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Aspect
@Configuration
public class AspectJConfiguration {
	private Logger logger=LoggerFactory.getLogger(this.getClass()); 
@Before("execution(* getAllEmployees())")
	public void demo(JoinPoint joinPoint) {
		System.out.println("his");
		logger.info("{}",joinPoint);

	}
}
