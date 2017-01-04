package com.icephone.service;

import java.util.Map;

import com.icephone.model.WorkDetial;
import com.icephone.pojo.Users;


public interface UserService
{
	public  Map<String,Object> login(String username,String userpsw);
	public Users getUserById(String userId);
	
	
	public WorkDetial getWorkInfo(String userId);
}
