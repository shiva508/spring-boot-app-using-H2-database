package com.example.demo.dependancyInjectionBeansAutoWiring;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigByName {
	
	@Bean(autowire = Autowire.BY_NAME)
	public ServiceBeanByName serviceBeanByType() {
		return new ServiceBeanByName();
	}
	@Bean
	public ServiceBeanByName serviceByType1() {
		return new ServiceBeanByName();
	}

}
