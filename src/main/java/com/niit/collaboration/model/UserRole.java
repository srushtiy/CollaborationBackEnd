package com.niit.collaboration.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;
//if it is a post method - read from requestbody; if get method - read from url

//if in the future admin wants to create more roles - role DAO and role controller needed - we should be able to create from UI - or through insert query in the role table 
// write test cases for each DAO to test connection to Oracle 

@Entity
@Component
@Table
public class UserRole {
	
	@Id
	private String role_id;
	private String role;
	private String userid;
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public UserRole(){
		this.role_id = "R" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
}