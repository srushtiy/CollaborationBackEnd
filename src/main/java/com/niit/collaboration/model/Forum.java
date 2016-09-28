package com.niit.collaboration.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Component
@Table
public class Forum {
	@Id
	private String forum_id;
	private String forumtitle;
	private String forum_description;
	private String  post_number;
	private String userid;
	private int posts;
	private Date date_created;
	private Date date_modified;
	private String status;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "forum")
	@JsonManagedReference
	private Set<ForumPost> forumPosts = new HashSet<>();
	
	public Set<ForumPost> getForumPosts() {
		return forumPosts;
	}
	public void setForumPosts(Set<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}
	public String getForumtitle() {
		return forumtitle;
	}
	public void setForumtitle(String title) {
		this.forumtitle = title;
	}
	public String getPost_number() {
		return post_number;
	}
	public void setPost_number(String post_number) {
		this.post_number = post_number;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getPosts() {
		return posts;
	}
	public void setPosts(int posts) {
		this.posts = posts;
	}
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
	
	public Forum(){
		this.setForum_id('F' + UUID.randomUUID().toString().substring(24).toUpperCase());
	}
	public String getForum_id() {
		return forum_id;
	}
	public void setForum_id(String forum_id) {
		this.forum_id = forum_id;
	}
	public String getForum_description() {
		return forum_description;
	}
	public void setForum_description(String forum_description) {
		this.forum_description = forum_description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}