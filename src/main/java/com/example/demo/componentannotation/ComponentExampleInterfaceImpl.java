package com.example.demo.componentannotation;

import org.springframework.stereotype.Component;

@Component
public class ComponentExampleInterfaceImpl implements ComponentExampleInterface{
	@Override
	public void showmethemoney() {
		System.out.println("this the money");
	}
}
