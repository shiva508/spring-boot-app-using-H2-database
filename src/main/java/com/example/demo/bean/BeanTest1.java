package com.example.demo.bean;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class BeanTest1 extends BeanTest {

	@Override
	public String getName(String name) {
	try {
		FileOutputStream fileoutput=new FileOutputStream("/home/ram/Downloads/sts-bundle/sts-3.9.4.RELEASE/2.txt");
			FileWriter fileWriter=new FileWriter("/home/ram/Downloads/sts-bundle/sts-3.9.4.RELEASE/1.txt", true);
		byte [] bytes=name.getBytes();
	
			fileoutput.write(bytes);
		//fileWriter.write(name);
		
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	} catch (IOException  e) {
		// TODO: handle exception
	}
	
		return "My name is "+name;
	}

}
