package com.icephone.service;

import java.util.List;
import java.util.Map;

import com.icephone.model.WorkDetial;
import com.icephone.pojo.Users;


public interface UserService
{
	public  Map<String,Object> login(String username,String userpsw);
	
	public Users getUserById(String userId);
	
	public boolean updateUser(Users user) throws Exception;
	
	public String addUser(String name,String acount,String psw,int type);
	
	public List getAdminInfo() throws Exception;
	
	public WorkDetial getWorkInfo(String userId);
	
	public boolean deleteByUserId(String userId);
	
	public List getWorkerInfo();
}
