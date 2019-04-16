package com.example.demo.model.IDGENERATORS.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class StudentIDENTITY {
	/*
	 * The GenerationType.IDENTITY is the easiest to use but not the best one from a
	 * performance point of view. It relies on an auto-incremented database column
	 * and lets the database generate a new value with each insert operation. From a
	 * database point of view, this is very efficient because the auto-increment
	 * columns are highly optimized, and it doesn’t require any additional
	 * statements.
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "STUDENT_ID", nullable = false, updatable = false)
	private Integer studentId;
	private String firstName;
	private String lastName;
	private String email;
	@Override
	public String toString() {
		return "StudentAUTO [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}
}
