package com.icephone.controller;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.model.HkApplyDetial;
import com.icephone.pojo.HkApply;
import com.icephone.service.HworkApplyService;
import com.icephone.service.HworkService;
import com.icephone.util.Constants;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;



@Controller
@RequestMapping("hworkapply")
public class HworkApplyController {

	@Autowired
	private HworkApplyService hwApplyService;
	
	@ResponseBody
	@RequestMapping(value="/applyHwork",method=RequestMethod.POST)
	public Map<String, Object> applyHwork(@RequestParam String hwId,@RequestParam String UId)
	{
		
		int haStatusCode  = Constants.HWORK_APPLY_STATUS_USEFUL;
		Timestamp haDate = TimeUtil.getTimeNow();
		HkApply hkApply = new HkApply(hwId,UId,haDate,haStatusCode);
		hwApplyService.addHworkApply(hkApply);
		return ResponseMapUtil.responseSuccess("success",null);
	}
	@ResponseBody
	@RequestMapping(value="/getApplyHworkDetial",method=RequestMethod.POST)
	public Map<String, Object> getApplyHworkDetial(@RequestParam String hwId)
	{
		HkApplyDetial detial = hwApplyService.getApplyDetial(hwId);
		return ResponseMapUtil.responseSuccess("success", detial);
		
	}
}
