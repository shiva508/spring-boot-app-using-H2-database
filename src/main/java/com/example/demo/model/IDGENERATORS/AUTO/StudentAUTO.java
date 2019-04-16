package com.example.demo.model.IDGENERATORS.AUTO;

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
public class StudentAUTO {
	/*
	 * The GenerationType.AUTO is the default generation type and lets the
	 * persistence provider choose the generation strategy
	 */
	/*
	 * If you use Hibernate as your persistence provider, it selects a generation
	 * strategy based on the database specific dialect. For most popular databases,
	 * it selects GenerationType.SEQUENCE
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
