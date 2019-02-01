package com.example.demo.model.onetomany;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserR {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USERR_ID")
	private Integer userRId;
	private String login;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "USERR_ROLER", joinColumns = {
			@JoinColumn(name = "USERR_ID", referencedColumnName = "USERR_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "ROLER_ID", referencedColumnName = "ROLER_ID") })
	private RoleR roler;

	public UserR() {
		super();
	}

	public Integer getUserRId() {
		return userRId;
	}

	public void setUserRId(Integer userRId) {
		this.userRId = userRId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleR getRoler() {
		return roler;
	}

	public void setRoler(RoleR roler) {
		this.roler = roler;
	}

	@Override
	public String toString() {
		return "UserR [userRId=" + userRId + ", login=" + login + ", password=" + password + ", roler=" + roler + "]";
	}

}
