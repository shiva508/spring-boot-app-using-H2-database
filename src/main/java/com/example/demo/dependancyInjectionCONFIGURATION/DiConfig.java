package com.example.demo.dependancyInjectionCONFIGURATION;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

public class DiConfig {
	@Autowired
	DataSourceConfig dataSourceConfig;

	@Bean
	public Client client() {
		return new Client(dataSourceConfig.dataSourceBean());
	}
	@PostConstruct
	public void Post() {
		System.out.println("DiConfig:POST CONSTRUCT");
	}
}
