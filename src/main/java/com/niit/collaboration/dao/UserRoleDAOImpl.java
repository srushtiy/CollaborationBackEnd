package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.UserRole;

@Repository(value = "userRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {

	@Autowired
	SessionFactory sessionFactory;

	public UserRoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateUserRole(UserRole userRole) {
		sessionFactory.getCurrentSession().saveOrUpdate(userRole);
	}

	@Transactional
	public void deleteUserAuthority(String userid) {
		UserRole userRole = new UserRole();
		userRole.setUserid(userid);
		sessionFactory.getCurrentSession().delete(userRole);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public UserRole getUserAuthority(String userid) {
		String hql = "from UserRole where userid=" + "'" + userid + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserRole> gotUserRole= query.list();
		if (gotUserRole != null && !gotUserRole.isEmpty())
			return gotUserRole.get(0);
		return null;
	}
}
