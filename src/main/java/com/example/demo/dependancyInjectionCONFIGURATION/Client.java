package com.example.demo.dependancyInjectionCONFIGURATION;

public class Client {
	DataSourceBean dataSourceBean;

	public Client(DataSourceBean dataSourceBean) {
		this.dataSourceBean = dataSourceBean;
	}

	public void showData() {
		System.out.println(dataSourceBean.getData());
	}
}
