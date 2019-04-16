package com.example.demo.model.NATIONALIZED.NVARCHAR;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class ProductNVARCHAR {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	/*
	 * To map a specific attribute to a nationalized variant data type, Hibernate
	 * defines the @Nationalized annotation.
	 */
	@Nationalized
	 private String warranty;
}
