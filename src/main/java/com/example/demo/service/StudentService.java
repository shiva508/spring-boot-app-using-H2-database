package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
	public void saveStudent(Student student);
	public List<Student> getAllStudents();
	public List<String> getAllName();
	public List<Student> getAllStudentsByID(int id);
	public Long getMaxID();
	public void Update(int id);
	public void remove(int id);
}
