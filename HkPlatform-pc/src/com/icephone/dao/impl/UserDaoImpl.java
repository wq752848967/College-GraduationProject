package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.UserDao;
import com.icephone.pojo.Users;
import com.icephone.util.Constants;


@Repository
public class UserDaoImpl extends BaseDaoImpl implements UserDao
{

	@Override
	public Users getUserById(String userId)
	{
		return super.getById(Users.class, userId);
	}

	@Override
	public Object getUserByPhone(String userPhone) {
		String hql = "From Users where UPhone  = ?";
		return this.getHibernateTemplate().find(hql,userPhone);
		
	}

	@Override
	public List getALLAdmin() throws Exception {
		String hql = "From Users where UStatusCode  != ?";
		return this.getHibernateTemplate().find(hql,Constants.USER_STATUS_DELETE);
	
	}

	@Override
	public List getUserByUserType(String type) {
		String user_status_nomal = Constants.USER_STATUS_DELETE+"";
		int userType = Integer.parseInt(type);
		String hql = "From Users where UTypeCode  = ? and UStatusCode !="+user_status_nomal;
		return this.getHibernateTemplate().find(hql,userType);
		
	}

}
