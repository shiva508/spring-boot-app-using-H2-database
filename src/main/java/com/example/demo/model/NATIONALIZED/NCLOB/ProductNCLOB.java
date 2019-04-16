package com.example.demo.model.NATIONALIZED.NCLOB;

import java.sql.NClob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
public class ProductNCLOB {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	
	// Clob also works, because NClob extends Clob.
    // The database type is still NCLOB either way and handled as such.
	/*
	 * To persist such an entity, you have to create an NClob using the NClobProxy
	 * Hibernate utility:
	 */
	/*
	 * To retrieve the NClob content, you need to transform the underlying
	 * java.io.Reader:
	 */
	@Lob
	@Nationalized
	private NClob warrenty;
	/*
	 * We could also map the NCLOB in a materialized form. This way, we can either
	 * use a String or a char[].
	 */
	@Lob
	@Nationalized
	private String warrenty1;
	@Lob
	@Nationalized
	private char[] warrenty2;
}
