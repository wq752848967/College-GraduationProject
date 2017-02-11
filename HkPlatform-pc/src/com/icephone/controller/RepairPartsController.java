package com.icephone.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.pojo.RepairParts;
import com.icephone.service.RepairPartsService;
import com.icephone.util.MapConvertUtils;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;


@Controller
@RequestMapping("/repairpart")
public class RepairPartsController {

	@Autowired
	private RepairPartsService repairPartsService;
	
	
	@ResponseBody
	@RequestMapping(value="/getAllKinds",method=RequestMethod.POST)
	public Map<String,Object> addPart(@RequestParam String pName,@RequestParam String pParts){
	
		System.out.println("1body:"+pName+" "+pParts);
		/*
		 //web frontplatform check param
		Map<String, Object> mapParams = MapConvertUtils.getMapFromString(body);
		String pName =  mapParams.get("pName").toString();
		String pParts = mapParams.get("pParts").toString();
		*/
		Timestamp rpDate = TimeUtil.getTimeNow();
		RepairParts repairParts = new RepairParts(pName, pParts, rpDate, 1);
		boolean result = repairPartsService.addParts(repairParts);
		//boolean result = true;
		if(result){
			return ResponseMapUtil.responseSuccess("success", null);
		}
		else{
			return ResponseMapUtil.responseSuccess("error", null);
		}
		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/getAllParts",method=RequestMethod.POST)
	public Map<String,Object> getAllParts(){
	
		List list = repairPartsService.getAllParts();
		
		return ResponseMapUtil.responseSuccess("success", list);
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePartsContent",method=RequestMethod.POST)
	public Map<String,Object> updatePartsContent(@RequestParam String pName,@RequestParam String pParts,
			@RequestParam int pId,@RequestParam int pStatus){
	
		System.out.println("update");
		/*Map<String, Object> mapParams = MapConvertUtils.getMapFromString(body);
		String pName =  mapParams.get("pName").toString();
		String pParts = mapParams.get("pParts").toString();
		int pId;
		int pStatus;
		try {
			pId =  Integer.parseInt(mapParams.get("pId").toString());
			pStatus =  Integer.parseInt(mapParams.get("pStatus").toString());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		*/
		boolean result = repairPartsService.updatePartsContent(pId, pName, pParts, pStatus);
		if(result){
			return ResponseMapUtil.responseSuccess("success", null);
		}
		else{
			return ResponseMapUtil.responseError("error", null);
		}
		
		
	}
}
