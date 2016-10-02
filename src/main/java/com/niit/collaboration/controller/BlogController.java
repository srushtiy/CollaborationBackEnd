package com.niit.collaboration.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.BlogDAO;
import com.niit.collaboration.model.Blog;

import ch.qos.logback.classic.Logger;

@RestController
public class BlogController {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(BlogController.class);
	
	@Autowired
	private BlogDAO blogDAO;
	
	@Autowired
	private Blog blog;
	
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getBlogs(){
		logger.debug("calling method getBlogs");
		List<Blog> list = blogDAO.list();
		if(list.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Blog>>(list, HttpStatus.OK);
			
	}
	
	@GetMapping("/blogs/{blog_id}")
	public ResponseEntity<Blog> getBlog(@PathVariable("id") String id){
		logger.debug("Calling method getBlogs with the the id" + id);
		blog = blogDAO.getByID(id);
		if (blog == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	@PostMapping(value="/blogs")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
		logger.debug("calling method createBlog");
		
		if (blogDAO.getByID(blog.getBlog_id())== null){
			blogDAO.saveOrUpdate(blog);
			return new ResponseEntity<Blog>(blog, HttpStatus.OK);
		}
		
		return new ResponseEntity<Blog>(blog, HttpStatus.CONFLICT);
	}

	@DeleteMapping("/blogs/{blog_id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable("blog_id") String id){
		logger.debug("calling method deleteBlog with the id" + id);
		if (blogDAO.getByID(id)!=null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.deleteBlog(id);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	@PutMapping("/blogs/{blog_id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable("blog_id") String id,@RequestBody Blog blog){
		logger.debug("calling method updateBlog with the id" + id);
		if (blogDAO.getByID(id)== null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(HttpStatus.OK);
}
}