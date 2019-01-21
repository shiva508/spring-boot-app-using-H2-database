package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.annotation.Rolenumber;
import com.example.demo.annotation.Shiva;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Table(name = "tblPersons")
@Entity

public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	// ONE_TO_ONE MAP
	// @OneToOne
	
	// ONE_TO_ONE LAZY
	// @OneToOne(fetch=FetchType.EAGER)
	
	// ONE_TO_ONE JOIN COLUMN
	// @OneToOne
	// @JoinColumn(name="DEPARTMENT_ID")
	
	//ONE_TO_ONE PRIMARY KEY
	// @OneToOne
	// @PrimaryKeyJoinColumn
	
	//MAP CASCADE
	@OneToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
}
