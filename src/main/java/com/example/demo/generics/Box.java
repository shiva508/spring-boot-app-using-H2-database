package com.example.demo.generics;

public class Box {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public static void main(String[] args) {
		Box box=new Box();
		box.setObject("Shiva");
	}
}
