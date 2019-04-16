package com.example.demo.model.IDGENERATORS.TABLE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class StudentTABLE {
	/*
	 * The GenerationType.TABLE gets only rarely used nowadays. It simulates a
	 * sequence by storing and updating its current value in a database table which
	 * requires the use of pessimistic locks which put all transactions into a
	 * sequential order. This slows down your application, and you should,
	 * therefore, prefer the GenerationType.SEQUENCE, if y our database supports
	 * sequences, which most popular databases do.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "STUDENT_ID", nullable = false, updatable = false)
	/*
	 * You can use the @TableGenerator annotation in a similar way as the already
	 * explained @SequenceGenerator annotation to specify the database table which
	 * Hibernate shall use to simulate the sequence.
	 */
	//@GeneratedValue(strategy=GenerationType.TABLE,generator="stu_generator")
	//@TableGenerator(name="stu_generator",schema="test",table="id_generator")
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
