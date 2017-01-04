package com.icephone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.service.RepairInfoService;
import com.icephone.util.ResponseMapUtil;


@Controller
@RequestMapping("/repairInfo")
public class RepairCountInfoController {

	
	@Autowired
	private RepairInfoService repairInfoService;
	@ResponseBody
	@RequestMapping(value="/getAll",method=RequestMethod.POST)
	public Map<String, Object> getAllRepairCountInfo(){
		List resultList = repairInfoService.getRepairCountInfo();
		return ResponseMapUtil.responseSuccess("success", resultList);
	}
}
