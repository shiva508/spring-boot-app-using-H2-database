package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
@Entity
@Table(name="roles_jdbc")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name="getAllRoleJdbc",procedureName="getAll_Role_Jdbc",resultClasses=RoleJdbc.class) 
	})
public class RoleJdbc {
	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO)*/
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="ROLE")
	private String role;
	@Column(name = "USER_NAME")
	private String userName;
	public RoleJdbc() {
		super();
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
