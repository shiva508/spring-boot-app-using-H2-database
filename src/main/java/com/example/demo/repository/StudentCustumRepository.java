package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentCustumRepository {
public void saveStudent(Student student);
public List<Student> getAllStudents();
public List<String> getAllName();
public List<Student> getAllStudentsByID(int id);
public Long getMaxID();
public void Update(int id);
public void remove(int id);
}
