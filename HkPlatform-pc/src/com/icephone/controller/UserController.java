package com.icephone.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.model.WorkDetial;
import com.icephone.model.WorkerModel;
import com.icephone.pojo.Users;
import com.icephone.service.RepairWorkerService;
import com.icephone.service.UserService;
import com.icephone.util.Constants;
import com.icephone.util.ResponseMapUtil;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;
	
	@Autowired
	private RepairWorkerService repairWorkerService;

	@ResponseBody
	@RequestMapping(value="/login")
	public Map<String,Object> login(@RequestParam String adminName,@RequestParam String adminPsw){
		Map<String,Object> resultMap = userService.login(adminName, adminPsw);
		String result = resultMap.get("result").toString();
		if(result.equals("success")){
			//存放session
			session.setAttribute("userId", resultMap.get("userId").toString());
			return ResponseMapUtil.responseSuccess("success", null);
		}
		else{
			return ResponseMapUtil.responseError(result, null);
		}
		
	}
	
	/**
	 *  
	 *  add Admin aocunt to db
	 *  
	 * @param adminName
	 * @param adminAcount
	 * @param adminPsw
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addAdmin")
	public Map<String,Object> login(@RequestParam String adminName,@RequestParam String adminAcount
			,@RequestParam String adminPsw){
		userService.addUser(adminName, adminAcount, adminPsw, Constants.USER_TYPE_ADMIN);
		return ResponseMapUtil.responseSuccess("success", null);
		
		
	}
	/**
	 *  add worker
	 *  
	 * @param workName
	 * @param workAcount
	 * @param workPsw
	 * @param workType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addWorker")
	public Map<String,Object> addWorker(@RequestParam String workName,@RequestParam String workAcount
			,@RequestParam String workPsw,@RequestParam String workType){
		String userId  = null;
		userId = userService.addUser(workName, workAcount, workPsw, Constants.USER_TYPE_WORK);
		
		try {
			
			repairWorkerService.addWorker(userId,workType);
		} catch (Exception e) {
			//删除用户
			userService.deleteByUserId(userId);
			return ResponseMapUtil.responseError("error", null);
		}
		
		return ResponseMapUtil.responseSuccess("success", null);
		
		
	}
	/**
	 * update admin status
	 * 
	 * 
	 * @param adminId
	 * @param statusType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/updateAdminStstus")
	public Map<String,Object> updateAdminStstus(@RequestParam String adminId,@RequestParam int statusType){
		System.out.println("id:"+adminId+"  "+statusType);
		try {
			if(statusType==1){
				//change to nomal
				Users user = userService.getUserById(adminId);
				user.setUStatusCode(Constants.USER_STATUS_NOMAL);
				userService.updateUser(user);
			}
			else if(statusType==2){
				//change to prohibit
				Users user = userService.getUserById(adminId);
				user.setUStatusCode(Constants.USER_STATUS_PROHIBIT);
				userService.updateUser(user);
			}
			else if(statusType==3){
				Users user = userService.getUserById(adminId);
				user.setUStatusCode(Constants.USER_STATUS_DELETE);
				userService.updateUser(user);
			}
			else{
				//nothing
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", null);
	}
	
	/**
	 * get all admin acount info accpt this
	 * acount has been delete
	 * 
	 * @return user List
	 */
	@ResponseBody
	@RequestMapping(value="/getAllAdmin")
	public Map<String,Object> getAllAdmin(){
		List adminList = null;
		try {
			adminList = userService.getAdminInfo();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
			adminList = null;
		}
		
		
		
		if(adminList != null){
			
			return ResponseMapUtil.responseSuccess("success", adminList);
			
		}
		else{
			
			return ResponseMapUtil.responseError("error", null);
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getAllWorker")
	public Map<String,Object> getAllWorker(){
		List<WorkerModel> workerList = null;
		try {
			workerList = userService.getWorkerInfo();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
			workerList = null;
		}
		
		
		
		if(workerList != null){
			
			return ResponseMapUtil.responseSuccess("success", workerList);
			
		}
		else{
			
			return ResponseMapUtil.responseError("error", null);
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getworkInfo")
	public Map<String,Object> getworkInfo(@RequestParam String userId){
		WorkDetial detial =  userService.getWorkInfo(userId);
		return ResponseMapUtil.responseSuccess("success", detial);
	}
	
	@ResponseBody
	@RequestMapping(value="/getUserInfo")
	public Map<String,Object> getUserInfo(@RequestParam String userId){
		Users user =  userService.getUserById(userId);
		return ResponseMapUtil.responseSuccess("success", user);
	}
	@ResponseBody
	@RequestMapping(value="/getUserType",method=RequestMethod.POST)
	public Map<String,Object> getworkInfo(){
		
		String userId = session.getAttribute("userId").toString();
		//String userId = "USER12345678121212";
		
		
		Users user = userService.getUserById(userId);
		
		
		return ResponseMapUtil.responseSuccess("success", user.getUTypeCode());
	}
}
