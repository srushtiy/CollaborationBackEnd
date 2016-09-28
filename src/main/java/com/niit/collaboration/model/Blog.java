package com.niit.collaboration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
public class Blog implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private String blog_id;
	private String userid;
	private String blog_title;
	private String blog_description;
	private Date date_created;
	private Date date_modified;
	private char status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "blog")
	@JsonManagedReference
	private Set<BlogComment> blogcomments = new HashSet<>();
	
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Date getDate_modified() {
		return date_modified;
	}
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	//private long comment_no;
	public String getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getBlog_description() {
		return blog_description;
	}
	public void setBlog_description(String blog_description) {
		this.blog_description = blog_description;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char approval_status) {
		this.status = approval_status;
	}
	public Blog(){
		this.blog_id = 'B' + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	@Override
	public String toString(){
		return "Blog (Blog Id=" + blog_id + ", Blog Name=" + blog_title + ", User Id=" + userid + ", Blog Description="
				+ blog_description + ", status=" + status + ", Create On=" + date_created + ", Modified On=" + date_modified;
	}
	
}
