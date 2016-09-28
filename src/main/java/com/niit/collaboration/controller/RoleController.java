/*package com.niit.collaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaboration.dao.RoleDAO;
import com.niit.collaboration.model.Role;
import com.niit.collaboration.model.UserRole;

@RestController
public class RoleController {

	@Autowired
	Role role;
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	UserRole userRole;
	
	public ResponseEntity<List<Role>> listAllRoles(){
		List<Role> role = roleDAO.list();
		if(role.isEmpty()){
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(role, HttpStatus.OK);
	}
	
}
*/