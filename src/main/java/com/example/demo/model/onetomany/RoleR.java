package com.example.demo.model.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
/* @Table(name = "ROLER") */
public class RoleR {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ROLER_ID")
	private Integer rolerId;
	@Column(name = "ROLE")
	private String role;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USERR_ROLER", joinColumns = {
			@JoinColumn(name = "ROLER_ID", referencedColumnName = "ROLER_ID") }, inverseJoinColumns = {
					@JoinColumn(name = "USERR_ID", referencedColumnName = "USERR_ID") })

	private List<UserR> userList;

	public RoleR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRolerId() {
		return rolerId;
	}

	public void setRolerId(Integer rolerId) {
		this.rolerId = rolerId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<UserR> getUserList() {
		return userList;
	}

	public void setUserList(List<UserR> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "RoleR [rolerId=" + rolerId + ", role=" + role + ", userList=" + userList + "]";
	}

}
