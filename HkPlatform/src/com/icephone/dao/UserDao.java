package com.icephone.dao;


import com.icephone.pojo.Users;


public interface UserDao extends BaseDao
{
	public Users getUserById(String userId);
	
	public Object getUserByPhone(String userPhone);
}
