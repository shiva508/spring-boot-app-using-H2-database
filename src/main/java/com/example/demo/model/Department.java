package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private long id;
	  
	  private String name;
	/*  ONE_TO_ONE JOIN COLUMN*/
	  //@OneToOne(mappedBy="department")
	 /* ONE_TO_ONE PRIMARY KEY*/
	//@OneToOne(mappedBy="department")
	  //ONE TO ONE CASCADE
	  @OneToOne(cascade=CascadeType.ALL,mappedBy="department")
	  private Person person;
	  public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getId() {
	    return id;
	  }

	  public void setId(long id) {
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
		return "Department [id=" + id + ", name=" + name + ", personId=" + person.getId() + "]";
	}

	
}
