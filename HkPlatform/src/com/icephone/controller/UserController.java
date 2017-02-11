package com.icephone.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.model.WorkDetial;
import com.icephone.pojo.Users;
import com.icephone.service.UserService;
import com.icephone.util.ResponseMapUtil;

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@ResponseBody
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Map<String,Object> login(@RequestParam String userPhone,@RequestParam String userPsw){
		Map<String,Object> resultMap = userService.login(userPhone, userPsw);
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
	
	@ResponseBody
	@RequestMapping(value="/getworkInfo")
	public Map<String,Object> getworkInfo(@RequestParam String userId){
		WorkDetial detial =  userService.getWorkInfo(userId);
		return ResponseMapUtil.responseSuccess("success", detial);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getUserType",method=RequestMethod.POST)
	public Map<String,Object> getworkInfo(){
		
		String userId = session.getAttribute("userId").toString();
		//String userId = "USER12345678121212";
		
		
		Users user = userService.getUserById(userId);
		
		
		return ResponseMapUtil.responseSuccess("success", user.getUTypeCode());
	}
	@ResponseBody
	@RequestMapping(value="/getUserInfo",method=RequestMethod.POST)
	public Map<String,Object> getUserInfo(){
		
		String userId = session.getAttribute("userId").toString();
		//String userId = "USER12345678121212";
		
		
		Users user = userService.getUserById(userId);
		
		
		return ResponseMapUtil.responseSuccess("success", user);
	}
}
