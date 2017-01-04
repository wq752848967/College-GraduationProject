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

import com.icephone.pojo.RService;
import com.icephone.pojo.Repairs;
import com.icephone.pojo.Users;
import com.icephone.service.RepairService;
import com.icephone.service.RserviceService;
import com.icephone.service.UserService;
import com.icephone.util.Constants;
import com.icephone.util.IdProviderUtils;
import com.icephone.util.MapConvertUtils;
import com.icephone.util.Page;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;


@Controller
@RequestMapping(value="/repair")
public class RepairController {

	@Autowired
	private RepairService repairService;
	
	
	@Autowired
	private RserviceService rserviceService;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private HttpSession session;
	
	
	@ResponseBody
	@RequestMapping(value="/getAllRepairByDate",method=RequestMethod.POST)
	public Map<String,Object> getAllRepairByDate(@RequestParam int pageNow,@RequestParam int pageSize){
		List resultList =  repairService.getAllRepairByDate();
		if(resultList==null){
			return ResponseMapUtil.responseError("error", null);
		}
		else{
			Page page = new Page();
			resultList = page.getPageList(resultList, pageNow, pageSize);
			Map map = ResponseMapUtil.responseSuccess("success", resultList);
			map.put("pageNow", pageNow);
			map.put("pageMax", page.getMaxPage());
			return map;
		}
	}
	
	
	
	
	
	
	
	
	/*  The following deprecated   */
	
	@ResponseBody
	@RequestMapping(value="/submitRepair",method=RequestMethod.POST)
	public Map<String,Object> submitRepair(@RequestBody String body)
	{
		
		Map<String, Object> mapParams = MapConvertUtils.getMapFromString(body);
		int repairType  =  1;
		Timestamp RDate = TimeUtil.getTimeNow();
		Repairs repair = new Repairs(IdProviderUtils.getRepairId(),mapParams.get("RTitle").toString(), mapParams.get("RAddr").toString(),mapParams.get("RDes").toString(), RDate,Constants.USER_STATUS_NOMAL,mapParams.get("UId").toString(),1,repairType);
		String result = repairService.addRepair(repair);
		if(repair.equals("success"))
		{
			return ResponseMapUtil.responseSuccess(result, null);
		}
		else
		{
			return ResponseMapUtil.responseError(result, null);
		}
		
	}
	@ResponseBody
	@RequestMapping(value="/serviceRepair",method=RequestMethod.POST)
	public Map<String,Object> serviceRepair(@RequestParam String workId,@RequestParam String rId){
		workId = session.getAttribute("userId").toString();
		Timestamp rsDate = TimeUtil.getTimeNow();
		String rsId = IdProviderUtils.getOrderId();
		int rsStatusCode = Constants.REPAIR_REPAIRING;
		RService service = new RService(rId, workId, rsDate, rsStatusCode);
		rserviceService.addRservice(service);
		
		//更改原有work的状态
		repairService.updateRepaie(rId, rsStatusCode);
		
		
		return ResponseMapUtil.responseSuccess("success", null);
		
		
	}
	@ResponseBody
	@RequestMapping(value="/getRepair",method=RequestMethod.POST)
	public Map<String,Object> getRepair(@RequestParam int repairType){
		String workId = session.getAttribute("userId").toString();
		//String workId = "USER12345678121212";
		//检查是否存在未完成订单
		
		
		
		//获取新订单
		Repairs repair = repairService.getRepair(repairType);
		if(repair==null){
			return ResponseMapUtil.responseError("error", null);
		}
		//添加关联对象s repair
		Timestamp rsDate = TimeUtil.getTimeNow();
		
		int rsStatusCode = Constants.REPAIR_REPAIRING;
		RService service = new RService(repair.getRId(), workId, rsDate, rsStatusCode);
		rserviceService.addRservice(service);
		//更新repair状态
		
		repairService.updateRepaie(repair.getRId(), Constants.REPAIR_REPAIRING);
		
		
		return ResponseMapUtil.responseSuccess("success", repair);
	}
	
	@ResponseBody
	@RequestMapping(value="/getRepairOrder",method=RequestMethod.POST)
	public Map<String,Object> getRepairOrder(){
		
		String userId = session.getAttribute("userId").toString();
		//String userId = "USER12345678121212";
		Users user = userService.getUserById(userId);
		int userType = user.getUTypeCode();
		if(userType==Constants.USER_TYPE_USER){
			//用户获取自己的订单
			List result = repairService.getByUserId(userId);
			return ResponseMapUtil.responseSuccess("success", result);
		}
		else{
			
			//工作者获取自己接受的订订单
			List result = repairService.getByWorkId(userId);
			return ResponseMapUtil.responseSuccess("success", result);
			
		}
		
	}
	
}
