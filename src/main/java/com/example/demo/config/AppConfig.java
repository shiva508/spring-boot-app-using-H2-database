package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.demo.bean.BeanTest1;
import com.example.demo.bean.ServiceBean;
import com.example.demo.interceptor.MYInterceotor;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	private MYInterceotor interceotor;
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceotor);	
	}
	

	@Bean
    public ServiceBean serviceBean2 () {
        return new ServiceBean("Service bean 2");
    }
	@Bean
	public BeanTest1 beanTest1() {
		return new BeanTest1();
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public Docket getRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		         .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	}
}
