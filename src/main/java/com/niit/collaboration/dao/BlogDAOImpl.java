package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.Blog;

@Repository(value="blogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteBlog(String blog_id) {
		Blog blog = new Blog();
		blog.setBlog_id(blog_id);
		try {
			sessionFactory.getCurrentSession().delete(blog);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Blog getByID(String blog_id) {
		String hql = "from Blog where blog_id=" + "'" + blog_id + "'";
		Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> listBlog= (List<Blog>) query.list();
		if (listBlog!= null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Blog> list() {
		String hql="from Blog";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Blog> listBlog=query.list();
		return listBlog;
	}
	
	
	

}
