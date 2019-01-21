package com.example.demo.repository;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
@Access(AccessType.FIELD)
@Entity
public class ProfessorPhoneAccessType {
	 public ProfessorPhoneAccessType() {
		super();
	}

	public static String LOCAL_AREA_CODE = "999";
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id;
	  public ProfessorPhoneAccessType(String phoneNum) {
		super();
		this.phoneNum = phoneNum;
	}

	@Transient
	  private String phoneNum;


	  public int getId() {
	    return id;
	  }

	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getPhoneNumber() {
	    return phoneNum;
	  }

	  public void setPhoneNumber(String num) {
	    this.phoneNum = num;
	  }
	  @Access(AccessType.PROPERTY)
	  @Column(name = "PHONE")
	  protected String getPhoneNumberForDb() {
	    if (null != phoneNum && phoneNum.length() == 10)
	      return phoneNum;
	    else
	      return LOCAL_AREA_CODE + phoneNum;
	  }

	  protected void setPhoneNumberForDb(String num) {
	    if (num.startsWith(LOCAL_AREA_CODE))
	      phoneNum = num.substring(3);
	    else
	      phoneNum = num;
	  }
}
