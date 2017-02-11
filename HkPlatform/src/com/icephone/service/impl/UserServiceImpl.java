package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.CommentsDao;
import com.icephone.dao.UserDao;
import com.icephone.model.WorkDetial;
import com.icephone.pojo.Comments;
import com.icephone.pojo.Users;
import com.icephone.service.UserService;
import com.icephone.util.Constants;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommentsDao commentsDao;

	@Override
	public Users getUserById(String userId) {
		Users user  = userDao.getUserById(userId);
		return user;
	}

	@Override
	public WorkDetial getWorkInfo(String userId) {
		WorkDetial wDetial = new WorkDetial();
		Users user  = userDao.getUserById(userId);
		user.setUPsw(null);
		wDetial.setUser(user);
		
		//get comments
		ArrayList<Comments> commentsList = new ArrayList<Comments>();
		List list =  commentsDao.getCommentByWId(userId);
		for(int i=0;i<list.size();i++){
			commentsList.add((Comments)list.get(i));
		}
			
		
		wDetial.setComments(commentsList);
		return wDetial;
	}

	@Override
	public Map<String,Object> login(String username, String userpsw) {
		 Map<String,Object> result = new HashMap<String, Object>();
		//寻找用户
		 
		Object obj = userDao.getUserByPhone(username);
		//用户是否存在
		if((obj==null)||(((List)obj).size()==0)){
			result.put("result", Constants.LOGIN_FAIL_NO_USER) ;
			return result;
		}
		
		Users user = (Users)(((List)obj).get(0));
		
		//用户状态
		int userStatus = (user).getUStatusCode();
		if(userStatus==Constants.USER_STATUS_PROHIBIT){
			result.put("result", Constants.LOGIN_FAIL_USER_STATUS_ERROR) ;
			
			return result;
		}
		
		//密码验证
		if((user).getUPsw().equals(userpsw)){
			result.put("result","success") ;
			result.put("userId", (user).getUId());
			return result;
		}
		 result.put("result",Constants.LOGIN_FAIL_USER_PSW_ERROR) ;
		 return result;
	}

	

}
