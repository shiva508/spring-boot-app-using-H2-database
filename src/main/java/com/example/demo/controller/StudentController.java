package com.example.demo.controller;

import java.security.Principal;

import java.util.Enumeration;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.BeanTest1;
import com.example.demo.exception.StudentErrorResponse;
import com.example.demo.exception.StutentNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Role;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.model.UserJdbc;
import com.example.demo.modelElementCollection.Customer;
import com.example.demo.modelElementCollection.CustomerRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserJdbcRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.StudentService;
import com.jfilter.filter.FieldFilterSetting;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
public class StudentController {
	@Autowired
	BeanTest1 benatest;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	StudentService service;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository  roleRepository;
	@Autowired
	EmployeeRepository  employeeRepository;
	@Autowired
	UserJdbcRepository userJdbcRepository;
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="/getaaluserjdbc",method=RequestMethod.GET)
	public List<UserJdbc>  getUserJdbc(){
		return userJdbcRepository.findAll();
	}
	
	@RequestMapping(value="/getAllEmployees",method=RequestMethod.GET)
	@FieldFilterSetting(fields= {"employeeId","phoneId"})
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	@RequestMapping(value="/getAll",method=RequestMethod.GET)
	@FieldFilterSetting(className=Student.class,fields= {"id","name"})
	public List<Student> getAllStudents(HttpServletRequest request){
		List<Student> all=service.getAllStudents();
	/*	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		System.out.println(currentPrincipalName);
		 Principal principal = request.getUserPrincipal();
		 System.out.println(principal.getName());*/
		 Enumeration headerNames = request.getHeaderNames();
	        while (headerNames.hasMoreElements()) {
	            String key = (String) headerNames.nextElement();
	            String value = request.getHeader(key);
	         System.out.println(key+"-"+value);
	        }
		request.setAttribute("all", all);
		return all;
	}
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET)
	@FieldFilterSetting(className=User.class,fields= {"id"})
	@FieldFilterSetting(className=Role.class,fields= {"id"})
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	@GetMapping(value="/getAllRoles")
	public List<Role> getAllRoles(){
	return 	roleRepository.findAll();
	}
	@GetMapping(value="/getAllNames")
	public List<String> getAllNames(){
		List<String> s=service.getAllName();
		return s;
	}
	@GetMapping(value="/getStudentById")
/*	http://localhost:8089/getStudentById/?id=2*/	
	public List<Student> getAllStudentsByID(@RequestParam("id")int id){
		List<Student> all=service.getAllStudentsByID(id);
		return all;
	}
	@GetMapping(value="/getStudentById1/{id}")
	/*http://localhost:8089/getStudentById1/2*/	
	public List<Student> getAllStudentsByID1(@PathVariable("id")int id){
		List<Student> all=service.getAllStudentsByID(id);
		if(all.size()<=0 ||id<=0) {
			throw new StutentNotFoundException("Sutudent is not found with id :"+id);
		}
		return all;
	}
	@GetMapping(value="/getMaxid")
	/*http://localhost:8089/getStudentById1/2*/	
	public Long getMaXid(){
		Long all=service.getMaxID();
		return all;
	}
	@GetMapping(value="/update/{id}")
	public List<String> updateStudent(@PathVariable("id")int id){
		/*use @ModelAttribute for spring form or use @RequestBody for ajax or angular*/
		service.Update(id);
		List<String> s=service.getAllName();
		return s;
	}
	@GetMapping(value="/remove/{id}")
	public List<String> removeStudent(@PathVariable("id")int id){
		service.remove(id);
		List<String> s=service.getAllName();
		return s;
	}
	@GetMapping(value="/test/{name}")
	
	public ResponseEntity<Object> testMethod(@PathVariable("name")String name) {
		//return benatest.getName(name);
		return new ResponseEntity<Object>(benatest.getName(name), HttpStatus.OK);
	
	}
	
}
