package com.example.demo.model.BLOB;

import java.sql.Blob;
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
public class ProductBLOB {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	/*
	 * To persist such an entity, you have to create a Blob using the BlobProxy
	 * Hibernate utility:
	 */
	@Lob
	private Blob image;
	private byte[] image1;
	@Override
	public String toString() {
		return "ProductBLOB [id=" + id + ", name=" + name + ", image=" + image + ", image1=" + Arrays.toString(image1)
				+ "]";
	}
	
}
