package com.niit.collaboration.dao;

import com.niit.collaboration.model.UserRole;

public interface UserRoleDAO {
	void saveOrUpdateUserRole(UserRole userRole);

	void deleteUserAuthority(String userid);

	UserRole getUserAuthority(String userid);
}
