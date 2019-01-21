package com.example.demo.bean;

public class ServiceBean {
	private String msg;

	public void get(String devel) {
		System.out.println("HIIII  " + devel);
	}

	public ServiceBean(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
