/*package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.BlogComment;

@Repository(value="blogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogCommentDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void deleteBlogComment(String blogcomment_id) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public BlogComment getBlogComment(String blogcomment_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<BlogComment> listBlogComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public List<BlogComment> listBlogByCreatedAt(String blog_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
*/