package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.JobOpp;

public interface JobOppDAO {
	
	void saveOrUpdate(JobOpp jobopp);
	
	void deleteOpp(String jobopp_id);
	
	JobOpp getJobOpp(String jobopp_id);
	
	List<JobOpp> list();
}
