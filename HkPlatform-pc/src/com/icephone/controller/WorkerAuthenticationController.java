package com.icephone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.service.WorkerAuthenticationService;
import com.icephone.util.ResponseMapUtil;



@Controller
@RequestMapping("/wa")
public class WorkerAuthenticationController {

	@Autowired
	private WorkerAuthenticationService workerAuthenticationService;
//getAllByDate
	@ResponseBody
	@RequestMapping(value="/getAllByDate",method=RequestMethod.POST)
	public Map<String,Object> getRecentWorkInfoByWorker(){
		List resultList = null;
		try {
			resultList = workerAuthenticationService.getAllByDate();
		} catch (Exception e) {
			e.printStackTrace();
			resultList = null;
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", resultList);
		
	}
}
