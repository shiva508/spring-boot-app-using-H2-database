package com.example.demo.model.CLOB;

import java.sql.Clob;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class ProductCLOB {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	/*
	 * To persist such an entity, you have to create a Clob using the ClobProxy
	 * Hibernate utility:
	 */
	/*
	 * To retrieve the Clob content, you need to transform the underlying
	 * java.io.Reader:
	 */
	@Lob
	private Clob warrenty;
	/*
	 * We could also map the CLOB in a materialized form. This way, we can either
	 * use a String or a char[]
	 */
	@Lob
	private String gaurenty;
	private char[] gaurenty1;
	
	@Override
	public String toString() {
		return "ProductCLOB [id=" + id + ", name=" + name + ", warrenty=" + warrenty + ", gaurenty=" + gaurenty
				+ ", gaurenty1=" + Arrays.toString(gaurenty1) + "]";
	}
}
