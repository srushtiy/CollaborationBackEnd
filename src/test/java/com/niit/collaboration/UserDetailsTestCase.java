package com.niit.collaboration;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserInfoDAO;
import com.niit.collaboration.model.Blog;
import com.niit.collaboration.model.UserInfo;

public class UserDetailsTestCase {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.collaboration");
		context.refresh();
		
		UserInfo user=(UserInfo) context.getBean("userInfo");
		UserInfoDAO userinfoDAO=(UserInfoDAO) context.getBean("userInfoDAO");
		user.setUserid("USR001");
		user.setFirst_name("Srushti");
		user.setLast_name("Y");
		user.setEnabled(true);
		user.setGender("Female");
		user.setUserType('S');
		user.setEmail("srushti@email.com");
		user.setContact_no("9877877887");
		user.setPassword("password");
		userinfoDAO.saveOrUpdate(user);
}
}
