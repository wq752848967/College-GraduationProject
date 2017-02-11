package com.icephone.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.CommentsDao;
import com.icephone.dao.RepairWorkerDao;
import com.icephone.dao.UserDao;
import com.icephone.model.WorkDetial;
import com.icephone.model.WorkerModel;
import com.icephone.pojo.Comments;
import com.icephone.pojo.RepairWorks;
import com.icephone.pojo.Users;
import com.icephone.service.UserService;
import com.icephone.util.Constants;
import com.icephone.util.IdProviderUtils;
import com.icephone.util.TimeUtil;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;
	@Autowired
	private CommentsDao commentsDao;

	@Autowired
	private RepairWorkerDao repairWorkerDao;
	
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
		 System.out.println("name:"+username);
		Object obj = userDao.getUserByPhone(username);
		//用户是否存在
		if(obj==null||(((List)obj).size()==0)){
			result.put("result", Constants.LOGIN_FAIL_NO_USER) ;
			return result;
		}
		
		Users user = (Users)(((List)obj).get(0));
		//判断用户类型
		int userType = user.getUTypeCode();
		if(userType!=Constants.USER_TYPE_ADMIN){
			result.put("result", Constants.LOGIN_FAIL_NO_USER) ;
			return result;
		}
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

	/**
	 *  service method
	 *  add user
	 *  1 user
	 *  2 admin
	 */
	@Override
	public String addUser(String name, String acount, String psw,int type) {
		//add Admin
		String userId = null;
		if(type==Constants.USER_TYPE_ADMIN){
			Users user = new Users();
			userId = IdProviderUtils.getUSERId();
			user.setUId(userId);
			user.setUDate(TimeUtil.getTimeNow());
			user.setUName(name);
			user.setUPhone(acount);
			user.setUPoints(0.00);
			user.setUPsw(psw);
			user.setUStatusCode(Constants.USER_STATUS_NOMAL);
			user.setUTypeCode(Constants.USER_TYPE_ADMIN);
			
			//add by dao method
			userDao.add(user);
			
		}
		else{
			Users user = new Users();
			userId = IdProviderUtils.getUSERId();
			user.setUId(userId);
			user.setUDate(TimeUtil.getTimeNow());
			user.setUName(name);
			user.setUPhone(acount);
			user.setUPoints(0.00);
			user.setUPsw(psw);
			user.setUStatusCode(Constants.USER_STATUS_NOMAL);
			user.setUTypeCode(type);
			
			//add by dao method
			userDao.add(user);
		}
		return userId;
	}

	@Override
	public List getAdminInfo()throws Exception {
		List adminList = userDao.getALLAdmin();
		
		return adminList;
	}

	@Override
	public boolean updateUser(Users user)throws Exception {
		userDao.update(user);
		return true;
	}

	@Override
	public boolean deleteByUserId(String userId) {
		Users user = userDao.getUserById(userId);
		userDao.delete(user);
		return true;
	}

	@Override
	public List getWorkerInfo() {
		List<WorkerModel> resultList = new ArrayList<WorkerModel>();
		List<Users> userList = userDao.getUserByUserType(Constants.USER_TYPE_WORK+"");
		if((userList!=null)&&(userList.size()!=0)){
			for (Users users : userList) {
				RepairWorks worker = repairWorkerDao.getByUserId(users.getUId());
				WorkerModel wModel = new WorkerModel();
				wModel.setUser(users);
				wModel.setWorker(worker);
				resultList.add(wModel);
			}
		}
		return resultList;
	}

	

}
