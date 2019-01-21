package com.example.demo.dependancyInjectionIMPORT;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientImport {
	@Autowired
	DataSourceBeanImport dataSourceBeanImport;
	
	public void showData() {
		System.out.println(dataSourceBeanImport.getData());
	}
}
