package com.example.demo.dependancyInjectionIMPORT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceConfigImport.class)
public class DiConfigImport {
	@Bean
	public ClientImport clientImport() {
		return new ClientImport();
	}
}
