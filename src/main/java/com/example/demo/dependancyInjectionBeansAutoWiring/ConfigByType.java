package com.example.demo.dependancyInjectionBeansAutoWiring;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigByType {
	/*
	 * Spring walks through type of each 'property' (the standard Java Bean
	 * property) of a given bean to match other registered beans type. If there's a
	 * match then the dependency injection happens. So basically this mode is
	 * entirely based on matching types
	 */
	/*
	 * In this mode, We don't need @Autowired at the injection point as Spring
	 * doesn't search for places which are annotated with
	 * @Autowired.
	 */
	/*
	 * In this mode of autowiring, the field injection doesn't work. There must be a
	 * setter. Spring scans all setters of a bean and if the type of property
	 * matches and there is no ambiguity then injects the target property
	 */
	@Bean(autowire = Autowire.BY_TYPE)
	public ServiceBeanByType serviceBeanByType() {
		return new ServiceBeanByType();
	}
	

}
