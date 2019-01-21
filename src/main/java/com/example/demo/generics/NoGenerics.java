package com.example.demo.generics;

import java.util.ArrayList;
import java.util.List;

public class NoGenerics {

	public static void main(String[] args) {
		List ls = new ArrayList();
		ls.add("Shiva");
		String s=(String) ls.get(0);//casting required
		System.out.println(ls.get(0));
		
		List<String> ls1=new ArrayList<>();
		ls1.add("Shiva");
		String s1=ls1.get(0);//no casting required
	}

}
