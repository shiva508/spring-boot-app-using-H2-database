package com.example.demo.exception;

public class StutentNotFoundException extends RuntimeException{

	public StutentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StutentNotFoundException(String message) {
		super(message);
		
	}

	public StutentNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
