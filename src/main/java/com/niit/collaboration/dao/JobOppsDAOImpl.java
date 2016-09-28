package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.JobOpp;

@Repository(value="jobOppDAO")
public class JobOppsDAOImpl implements JobOppDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public JobOppsDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(JobOpp jobopp) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobopp);
	}

	@Transactional
	public void deleteOpp(String jobopp_id) {	
		JobOpp jobOpportunityToDelete = new JobOpp();
		jobOpportunityToDelete.setJobOppId(jobopp_id);
		sessionFactory.getCurrentSession().delete(jobOpportunityToDelete);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public JobOpp getJobOpp(String jobopp_id) {
		String hql = "from JobOpp where jobopp_id=" + "'" + jobopp_id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<JobOpp> gotJobOpportunity = (List<JobOpp>) query.list();
		if (gotJobOpportunity != null && !gotJobOpportunity.isEmpty())
			return gotJobOpportunity.get(0);
		return null;
	}

	@Transactional
	public List<JobOpp> list() {
		return null;
	}
	

}