package com.example.demo.dependancyInjectionbean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class OrderConfiguration {
	@Bean(name = "OrderServiceA")
	public OrderService orderServiceByProvider1() {
		return new OrderServiceImpl1();
	}

	@Bean(name = "OrderServiceB")
	@Lazy
	/*
	 * By default Spring container instantiates all configured beans at startup
	 * (eager loading). In some situations, however, beans might rarely be used
	 * during application life cycle. Loading them at startup will, specially, be
	 * not good if they are going to use considerable memory to get initialized. In
	 * those sort of situations we may decide to initialize such beans only when
	 * they are first accessed by application code (i.e. initialize on demand). We
	 * can achieve that by using @Lazy on bean configuration method
	 */
	/* @Qualifier("OrderServiceB") */
	public OrderService orderServiceByProvider2() {
		return new OrderServiceImpl2();
	}
}
