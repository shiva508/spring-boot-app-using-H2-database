package com.example.demo.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table
public class PersonFindById implements Serializable {
	@Id
	/* @GeneratedValue(strategy=GenerationType.AUTO) */
	private Integer id;
	@Basic
	private String name;

	private String surname;
	//@Transient
	//@Basic(fetch = FetchType.EAGER)
	@Lob
	private byte[] pictures;
	@Column(name = "SQL_DATE", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date sqlDate;
	@Column(name = "CAL_DATE")
	@Temporal(TemporalType.DATE) // DATE,TIMESTAMP
	private java.util.Calendar calDate;
	@Column(name = "DATE_TO_TIME")
	@Temporal(TemporalType.TIME)
	private java.util.Date dateToTimeMAp;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date dataToTimestamp;

/*	public Map<String,String> getPhonenumbers;*/
	public PersonFindById() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public byte[] getPictures() {
		return pictures;
	}

	public void setPictures(byte[] pictures) {
		this.pictures = pictures;
	}

	public java.sql.Date getSqlDate() {
		return sqlDate;
	}

	public void setSqlDate(java.sql.Date sqlDate) {
		this.sqlDate = sqlDate;
	}

	public java.util.Calendar getCalDate() {
		return calDate;
	}

	public void setCalDate(java.util.Calendar calDate) {
		this.calDate = calDate;
	}

	public java.util.Date getDateToTimeMAp() {
		return dateToTimeMAp;
	}

	public void setDateToTimeMAp(java.util.Date dateToTimeMAp) {
		this.dateToTimeMAp = dateToTimeMAp;
	}

	public java.util.Date getDataToTimestamp() {
		return dataToTimestamp;
	}

	public void setDataToTimestamp(java.util.Date dataToTimestamp) {
		this.dataToTimestamp = dataToTimestamp;
	}

	@Override
	public String toString() {
		return "PersonFindById [id=" + id + ", name=" + name + ", surname=" + surname + ", pictures="
				+ Arrays.toString(pictures) + ", sqlDate=" + sqlDate + ", calDate=" + calDate + "]";
	}

}
