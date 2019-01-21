package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_jdbc")
public class UserJdbc {
	@Id
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String passWord;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "ENABLED")
	private Integer enabled;
	
	public UserJdbc() {
		super();
	}
	
	public UserJdbc(UserJdbc user) {
		super();
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.passWord = user.getPassWord();
		this.email = user.getPassWord();
		this.enabled = user.getEnabled();
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEnabled() {
		return enabled;
	}
	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}
	
}
