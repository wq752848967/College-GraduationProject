package com.icephone.dao;


import java.util.List;

import com.icephone.pojo.Users;


public interface UserDao extends BaseDao
{
	public List getALLAdmin() throws Exception;
	public Users getUserById(String userId);
	
	public Object getUserByPhone(String userPhone);
	
	public List getUserByUserType(String type);
}
