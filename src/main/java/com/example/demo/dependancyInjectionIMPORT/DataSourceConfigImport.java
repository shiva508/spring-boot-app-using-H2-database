package com.example.demo.dependancyInjectionIMPORT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfigImport {
	@Bean
	public DataSourceBeanImport dataSourceBeanImport() {
		return new DataSourceBeanImport();
	}
}
