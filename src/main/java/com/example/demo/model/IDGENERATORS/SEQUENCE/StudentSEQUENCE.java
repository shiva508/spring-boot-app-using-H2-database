package com.example.demo.model.IDGENERATORS.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
public class StudentSEQUENCE {
	
	/*
	 * The GenerationType.SEQUENCE is to generate primary key values and uses a
	 * database sequence to generate unique values. It requires additional select
	 * statements to get the next value from a database sequence. But this has no
	 * performance impact on most applications. And if your application has to
	 * persist a huge number of new entities, you can use some Hibernate specific
	 * optimizations to reduce the number of statements.
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//@Column(name = "STUDENT_ID", nullable = false, updatable = false)
	/*
	 * If you don’t provide any additional information, Hibernate will request the
	 * next value from its default sequence. You can change that by referencing the
	 * name of a @SequenceGenerator in the generator attribute of
	 * the @GeneratedValue annotation. The @SequenceGenerator annotation lets you
	 * define the name of the generator, the name, and schema of the database
	 * sequence and the allocation size of the sequence.
	 */
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="student_generator")
	@SequenceGenerator(name="student_generator",sequenceName="student_seq",allocationSize=10)
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
