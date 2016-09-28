package com.niit.collaboration.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class UserInfo {

	@Id
	private String userid;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String contact_no;
	private boolean enabled;
	private char userType;
	private String gender;
	
	/*@OneToMany(mappedBy="userInfo", fetch=FetchType.EAGER)
	private Set<UserRole> userRoles;*/

	/*public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}*/

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userinfoid) {
		this.userid = userinfoid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public UserInfo() {
		this.userid = "UI" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getUserType() {
		return userType;
	}

	public void setUserType(char userType) {
		this.userType = userType;
	}
}
