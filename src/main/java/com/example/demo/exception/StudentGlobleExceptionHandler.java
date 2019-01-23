package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentGlobleExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> studentNotFound(StutentNotFoundException exe){
		StudentErrorResponse res=new StudentErrorResponse();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setTimestamp(System.currentTimeMillis());
		res.setMessage(exe.getMessage());
		return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> wrongFormateError(Exception exe){
		StudentErrorResponse res=new StudentErrorResponse();
		res.setStatus(HttpStatus.BAD_REQUEST.value());
		res.setTimestamp(System.currentTimeMillis());
		res.setMessage(exe.getMessage());
		return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);	
	}
}
