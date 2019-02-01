package com.example.demo.mappers;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.converter.builtin.DateToStringConverter;

public class FormDomainMapper {
	private MapperFactory formDomainMapperFactory = null;

	public FormDomainMapper(MapperFactory mapperFactory) {
		this.formDomainMapperFactory = mapperFactory;
		ConverterFactory converterFactory = formDomainMapperFactory.getConverterFactory();
		converterFactory.registerConverter(new DateToStringConverter("MM-dd-yyyy HH:mm:ss"));
	}
}
