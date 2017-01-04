package com.icephone.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.management.j2ee.statistics.TimeStatistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.pojo.HkCollection;
import com.icephone.service.HkCollectionService;
import com.icephone.util.Constants;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;



@Controller
@RequestMapping("/hkCollection")
public class HkCollectionController {

	
	@Autowired
	private HkCollectionService hkCollectionService;
	
	@ResponseBody
	@RequestMapping(value="/collect",method=RequestMethod.POST)
	public Map<String,Object> collect(@RequestParam String hwId,@RequestParam String UId){
		
		Timestamp hcDate = TimeUtil.getTimeNow();
		int hcStatusCode = Constants.HWORK_COLLECTION_STATUS_USEFUL;
		HkCollection collection = new HkCollection(hwId, UId, hcDate, hcStatusCode);
		
		boolean result = hkCollectionService.addHkCollection(collection);
		if(result){
			return ResponseMapUtil.responseSuccess("success", null);
		}else{
			return ResponseMapUtil.responseError("error", null);
		}
		
		
	}
}
