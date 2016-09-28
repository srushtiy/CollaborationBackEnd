package com.niit.collaboration;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;


public class BlogTestCase {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		Blog blog=(Blog) context.getBean("blog");
		BlogDAO blogDAO=(BlogDAO) context.getBean("blogDAO");
		blog.setDate_created(new Date());
		blog.setDate_modified(new Date());
		blog.setBlog_description("This is a new blog");
		blog.setStatus('A');
		blog.setUserid("USR001");
		blog.setBlog_title("MYBlog");
		blogDAO.saveOrUpdate(blog);
}
}