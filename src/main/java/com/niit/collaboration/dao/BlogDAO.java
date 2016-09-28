package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Blog;

public interface BlogDAO {
	
	boolean saveOrUpdate (Blog blog);
	
	boolean deleteBlog(String blog_id);
	
	Blog getByID(String blog_id);
	
	List<Blog> list();
}
