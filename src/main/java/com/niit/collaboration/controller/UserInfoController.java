package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.UserInfoDAO;
import com.niit.collaboration.model.UserInfo;
import com.niit.collaboration.model.UserRole;

@RestController
public class UserInfoController {
	
	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Autowired
	private UserInfo userInfo;
	
	@Autowired
	private UserRole userRole;
	
	@GetMapping("/userInfo")
	public ResponseEntity<List<UserInfo>> getUsers(){
		List<UserInfo> list = userInfoDAO.list();
		if(list.isEmpty()){
			return new ResponseEntity<List<UserInfo>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<UserInfo>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/userInfo/{id}")
	public ResponseEntity<UserInfo> getUserInfo(@RequestParam("id") String id){
		UserInfo userInfo = userInfoDAO.getUserInfo(id);
		if (userInfo == null){
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
	}
	
	@PostMapping("/userInfo")
	public ResponseEntity<UserInfo>  createUser(@RequestBody UserInfo userInfo){
		if (userInfoDAO.getByEmail(userInfo.getEmail())==null){
			userInfoDAO.saveOrUpdate(userInfo);
			return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
		}
		return new ResponseEntity<UserInfo>(userInfo,HttpStatus.CONFLICT);
	}
	
	@PutMapping("/userInfo/{user_id}")
	public ResponseEntity<UserInfo> updateUser(@PathVariable("userid") String id,@RequestBody UserInfo userInfo){
		if (userInfoDAO.getUserInfo(id)== null){
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		userInfoDAO.saveOrUpdate(userInfo);
		return new ResponseEntity<UserInfo>(userInfo,HttpStatus.OK);
	}
	
	@DeleteMapping("/userInfo/{id}")
	public ResponseEntity<UserInfo> deleteUser(@PathVariable("id") String id){
		UserInfo userInfo = userInfoDAO.getUserInfo(id);
		if (userInfo == null){
			return new ResponseEntity<UserInfo>(HttpStatus.NOT_FOUND);
		}
		userInfoDAO.delete(id);
		return new ResponseEntity<UserInfo>(HttpStatus.OK);
	}
}
