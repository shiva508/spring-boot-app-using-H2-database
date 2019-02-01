package com.example.demo.dependancyInjectionCONFIGURATION;

import javax.annotation.PostConstruct;

public class DataSourceBean {
	public String getData() {
		return "some data";
	}

	@PostConstruct
	public void Post() {
		System.out.println("DataSourceBean:POST CONSTRUCT");
	}
}
