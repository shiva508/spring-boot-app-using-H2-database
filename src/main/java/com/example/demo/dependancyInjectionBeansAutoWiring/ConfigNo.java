package com.example.demo.dependancyInjectionBeansAutoWiring;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigNo {
	/*
	 * We have to explicitly use @Autowired at injection point. That means Spring
	 * doesn't do automatic wiring in this mode. We have to tell Spring that at what
	 * points bean wiring should happen by specifying @Autowired annotation at those
	 * points.
	 */
	@Bean(autowire = Autowire.NO)
	public ServiceBeanNo serviceBeanNo() {
		return new ServiceBeanNo();
	}

	/*
	 * There shouldn't be any conflict (ambiguity), which means there should be no
	 * more than one bean instance of the same type registered for a given injection
	 * point, otherwise we will have NoUniqueBeanDefinitionException
	 */
	@Bean
	public ServiceBeanNo serviceBeanNo1() {
		return new ServiceBeanNo();
	}

	@Bean
	public ServiceBeanNo serviceBeanNo2() {
		return new ServiceBeanNo();
	}

}
