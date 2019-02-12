package com.example.demo.config;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@ComponentScan(basePackages={"com.example.demo"})
public class AspectJConfiguration {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/* @Before("execution(* getAllEmployees())") */
	/* @Before("execution(* getAll*())") */
	@Before("execution(* com.example.demo.controller.*.*(..))")
	public void demo() {
		System.out.println("HEY I'AM WORKING FINE");

	}
}
