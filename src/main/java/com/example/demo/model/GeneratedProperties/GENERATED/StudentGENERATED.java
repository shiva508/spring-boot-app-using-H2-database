package com.example.demo.model.GeneratedProperties.GENERATED;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentGENERATED {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String firstName;

	private String lastName;

	private String middleName1;

	private String middleName2;

	private String middleName3;

	private String middleName4;

	private String middleName5;
	@Generated(GenerationTime.ALWAYS)
	@Column(columnDefinition  =
	"AS CONCAT(" +
	"COALESCE(firstName, ''), " +
	"COALESCE(' ' + middleName1, ''), " +
	"COALESCE(' ' + middleName2, ''), " +
	"COALESCE(' ' + middleName3, ''), " +
	"COALESCE(' ' + middleName4, ''), " +
	"COALESCE(' ' + middleName5, ''), " +
	"COALESCE(' ' + lastName, '') " +
	")")
	private String fullName;
}
