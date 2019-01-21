package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	private Integer employeeId;
	@Column(name="EMPLOYEE_NAME")
	private String name; 
	@Column(name="SALARY")
	private Long salary;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="EMP_PHONE",joinColumns= @JoinColumn(name="EMP_ID"),inverseJoinColumns=@JoinColumn(name="EMP_PHONE"))
	private Collection<Phone> phones;
	public Employee() {
		phones=new ArrayList<>();
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Collection<Phone> getPhones() {
		return phones;
	}
	public void addPhone(Phone phone) {
		if(!getPhones().contains(phone)) {
			getPhones().add(phone);
		}
		
	}
	public void setPhones(Collection<Phone> phones) {
		this.phones = phones;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", phones=" + phones
				+ "]";
	}
	
}
