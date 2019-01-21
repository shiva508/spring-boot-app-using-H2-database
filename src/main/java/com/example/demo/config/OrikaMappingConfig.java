package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.mappers.FormDomainMapper;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class OrikaMappingConfig {
@Bean
	public MapperFacade formDomainMapperFacade() {
		MapperFactory formDomineMapperFactory = new DefaultMapperFactory
				.Builder()
				.mapNulls(false)
				.build();
		
		FormDomainMapper formDomainMapper=new FormDomainMapper(formDomineMapperFactory);
	return formDomineMapperFactory.getMapperFacade(); 
	}
}
