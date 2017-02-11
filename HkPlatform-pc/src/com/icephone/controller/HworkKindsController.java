package com.icephone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.model.HworkKindModel;
import com.icephone.service.HworkKindsService;
import com.icephone.util.ResponseMapUtil;


@Controller
@RequestMapping("hworkKind")
public class HworkKindsController {

	@Autowired
	private HworkKindsService hworkKindsService;
	
	
	@ResponseBody
	@RequestMapping(value="/getAllWorkKind",method=RequestMethod.POST)
	public Map<String,Object> getAllWorkKind(){
		HworkKindModel model = null;
		try {
			model = hworkKindsService.getAllByDate();
		} catch (Exception e) {
			e.printStackTrace();
			model = null;
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", model);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/addWorkKind",method=RequestMethod.POST)
	public Map<String,Object> addWorkKind(@RequestParam String kindType,
			@RequestParam String kindName){
		
		try {
			hworkKindsService.addWorkKind(kindType, kindName);
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", null);
		
	}
	@ResponseBody
	@RequestMapping(value="/deleteWorkKind",method=RequestMethod.POST)
	public Map<String,Object> deleteWorkKind(@RequestParam String kindId){
		
		try {
			hworkKindsService.updateWorkKindStatus(kindId, "2");
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", null);
		
	}
	
}
