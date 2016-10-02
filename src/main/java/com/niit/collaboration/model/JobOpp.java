package com.niit.collaboration.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class JobOpp {
	
	@Id
	private String jobOppId;
	private String job_title;
	private String job_description;
	private Date date_posted;
	private Timestamp modified_time;
	public String getJobOppId() {
		return jobOppId;
	}
	public void setJobOppId(String jobOppId) {
		this.jobOppId = jobOppId;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getJob_description() {
		return job_description;
	}
	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public Timestamp getModified_time() {
		return modified_time;
	}
	public void setModified_time(Timestamp modified_time) {
		this.modified_time = modified_time;
	}
	
	public JobOpp(){
		this.jobOppId = 'J' + UUID.randomUUID().toString().substring(24).toUpperCase();
	}
	public Date getDate_posted() {
		return date_posted;
	}
	public void setDate_posted(Date date_posted) {
		this.date_posted = date_posted;
	}
}
