package com.icephone.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.pojo.Hworks;
import com.icephone.service.HworkService;
import com.icephone.util.IdProviderUtils;
import com.icephone.util.MapConvertUtils;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;




@Controller
@RequestMapping(value="/hwork")
public class HworkController {

	@Autowired
	private HworkService hworkService;
	
	@Autowired
	private HttpSession session;
	
	@ResponseBody
	@RequestMapping(value="/submitHwork",method=RequestMethod.POST)
	public Map<String,Object> submitHwork(@RequestBody String body)
	//public Map<String,Object> submitHwork(@RequestParam String hwPubUId,@RequestParam String hwTitle
			//,@RequestParam Double hwMoney,@RequestParam String hwDate,@RequestParam int hwTime,
		//	@RequestParam String hwAddr,@RequestParam String hwDesc,@RequestParam Integer hwTypeCode,@RequestParam Integer hwDTypeCode)
	{
		System.out.println("in submit:");	
		Map<String, Object> mapParams = MapConvertUtils.getMapFromString(body);
		
		
		
		String hwTitle = mapParams.get("hwTitle").toString();
		Double hwMoney = Double.valueOf(mapParams.get("hwMoney").toString());
		String hwDate = mapParams.get("hwDate").toString();
		
		int hwTime = Integer.parseInt(mapParams.get("hwTime").toString());
		String hwAddr = mapParams.get("hwAddr").toString();
		
		String hwDesc = mapParams.get("hwDesc").toString();
		int hwTypeCode = Integer.parseInt(mapParams.get("hwTypeCode").toString());
		int hwDTypeCode = Integer.parseInt(mapParams.get("hwDTypeCode").toString());
		
		//获取Session id;
		String hwPubUId = session.getAttribute("userId").toString();
		System.out.println("test:submit userId:"+hwPubUId+"  "+hwTitle);
		Timestamp hwPubDate = TimeUtil.getTimeNow();
		String hwId = IdProviderUtils.getHworkId();
		int hwVisitTime = 0;
		int hwApplyAmount = 0;
		String hwStatusCode = "1";
		Hworks hwork = new Hworks(hwId, hwPubUId, hwTitle, hwMoney, hwDate, hwTime, hwPubDate, hwVisitTime, hwApplyAmount, hwAddr, hwTypeCode, hwDTypeCode, hwDesc, Integer.parseInt(hwStatusCode));
		String result = hworkService.addHwork(hwork);
		if(result.equals("success"))
		{
			return ResponseMapUtil.responseSuccess(result, null);
		}
		else
		{
			return ResponseMapUtil.responseError(result, null);
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/getHworkList",method=RequestMethod.POST)
	public Map<String,Object> getHworkList()
	{
		System.out.println("get work List");
		List<Hworks> list = hworkService.getAllHworks();
		return ResponseMapUtil.responseSuccess(list.size()+"", list);
	}
	
	@ResponseBody
	@RequestMapping(value="/getHworkListByUId",method=RequestMethod.POST)
	public Map<String,Object> getHworkListByUId(@RequestParam String UId)
	{
		System.out.println("get work List");
		List<Hworks> list = hworkService.getHworksByUId(UId);
		return ResponseMapUtil.responseSuccess(list.size()+"", list);
	}
	
	@ResponseBody
	@RequestMapping(value="/getHworkById",method=RequestMethod.POST)
	public Map<String,Object> getHworkById(@RequestParam String hwId)
	{
		Hworks hwork = hworkService.getHworkById(hwId);
		
		return ResponseMapUtil.responseSuccess(hwId, hwork);
	}
	
	@ResponseBody
	@RequestMapping(value="/getHworkByOrder",method=RequestMethod.POST)
	public Map<String,Object> getHworkByOrder()
	{
		//String userId = "213";
		String userId = session.getAttribute("userId").toString();
		
		List list = hworkService.getHworkByOrder(userId);
		
		return ResponseMapUtil.responseSuccess("success", list);
	}
}
