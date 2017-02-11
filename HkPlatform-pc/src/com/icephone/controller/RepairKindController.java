package com.icephone.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.pojo.Hworks;
import com.icephone.pojo.RepairKinds;
import com.icephone.pojo.RepairParts;
import com.icephone.service.RepairKindService;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;


@Controller
@RequestMapping(value="/repairKind")
public class RepairKindController {
	
	@Autowired
	private RepairKindService repairKindService;
	
	
	/**
	 * get RepairKinds
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getAllKinds",method=RequestMethod.POST)
	public Map<String,Object> getHworkListUserful()
	{
		System.out.println("get repair kind List");
		List<RepairKinds> list = repairKindService.getAllKinds();
		Map<String, Object> result = ResponseMapUtil.responseSuccess("success", list);
		//result.put("", value)
		return result;
	}
	/**
	 *  add repair kind to db
	 * @param kindName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/addRepairKind",method=RequestMethod.POST)
	public Map<String,Object> addRepairKind(@RequestParam String kindName)
	{
		System.out.println("add repair kind");
		Timestamp rpDate = TimeUtil.getTimeNow();
		RepairKinds repairKind= new RepairKinds(kindName, rpDate, 1);
		
		try {
			repairKindService.addKind(repairKind);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		//boolean result = true;
		   
		return ResponseMapUtil.responseSuccess("success", null);
		
			
		
	}
	@ResponseBody
	@RequestMapping(value="/deleteRepairKind",method=RequestMethod.POST)
	public Map<String,Object> deleteRepairKind(@RequestParam String kindId)
	{
		System.out.println("deleteRepairKind repair kind");
		
		try {
			repairKindService.updateRepairKind(kindId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		//boolean result = true;
		   
		return ResponseMapUtil.responseSuccess("success", null);
		
			
		
	}
}
