package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.UserInfo;

public interface UserInfoDAO {
	
	public boolean saveOrUpdate(UserInfo userinfo);
		
	public boolean delete (String userinfo_id);
	
	public UserInfo getUserInfo(String id);
	
	public UserInfo get(String id, String password);
	
	public List<UserInfo> list();
	
	public UserInfo isValidUser(String id, String name);
}
