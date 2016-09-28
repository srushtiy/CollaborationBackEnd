package com.niit.collaboration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.model.UserInfo;

@Repository("userInfoDAO")
public class UserInfoDAOImpl implements UserInfoDAO {

/*	private static final Logger logger = (Logger) LoggerFactory.getLogger(UserInfoDAOImpl.class);
*/
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private UserInfo userInfo;

	public UserInfoDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(UserInfo userinfo) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userinfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean delete(String userinfo_id) {
		userInfo.setUserid(userinfo_id);
		try {
			sessionFactory.getCurrentSession().delete(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public UserInfo getUserInfo(String id) {
		String hql ="from UserInfo where userid = " + "'" + id + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserInfo> list = (List<UserInfo>) query.list();
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public UserInfo get(String id, String password) {
		String hql = "from UserInfo where userid ="+ "'" + id + "'" + "and password =" + "'" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserInfo> list = (List<UserInfo>) query.list();
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserInfo> list() {
		String hql = "from UserInfo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserInfo> list = (List<UserInfo>) query.list();
		return list;
	}

	@Transactional
	public UserInfo isValidUser(String id, String name) {
		return null;
	}

}
