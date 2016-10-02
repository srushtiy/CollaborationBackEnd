package com.niit.collaboration.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@Component
public class BlogComment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String blogcomment_id;
	private String userid;
	private String description;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy HH:mm:ss", timezone="IST")
	private Timestamp time_commented;
	
	public String getBlogcomment_id() {
		return blogcomment_id;
	}

	public void setBlogcomment_id(String blogcomment_id) {
		this.blogcomment_id = blogcomment_id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String comment) {
		this.description = comment;
	}

	public Timestamp getTime_commented() {
		return time_commented;
	}

	public void setTime_commented(Timestamp time_commented) {
		this.time_commented = time_commented;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_id", nullable = false)
	@JsonBackReference
	private Blog blog;
	
	public BlogComment(){
		this.blogcomment_id = "BC" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	
	
}
