package com.example.demo.dependancyInjectionRESOURCE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {
	@Bean(name="product1")
	public ProductService productService1() {
		return new ProductServiceImpl1();
	}
	@Bean(name="product2")
	public ProductService productService2() {
		return new ProductServiceImpl2();
	}
}
