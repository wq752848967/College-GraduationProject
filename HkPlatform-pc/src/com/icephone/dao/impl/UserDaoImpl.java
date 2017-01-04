package com.icephone.dao.impl;

import org.springframework.stereotype.Repository;

import com.icephone.dao.UserDao;
import com.icephone.pojo.Users;


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

}
