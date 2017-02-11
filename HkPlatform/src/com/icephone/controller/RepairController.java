package com.icephone.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.dao.UserDao;
import com.icephone.model.RepairServiceModel;
import com.icephone.pojo.RService;
import com.icephone.pojo.Repairs;
import com.icephone.pojo.Users;
import com.icephone.service.RepairService;
import com.icephone.service.RserviceService;
import com.icephone.service.UserService;
import com.icephone.util.Constants;
import com.icephone.util.IdProviderUtils;
import com.icephone.util.MapConvertUtils;
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
	@RequestMapping(value="/submitRepair",method=RequestMethod.POST)
	public Map<String,Object> submitRepair(@RequestParam String RTitle,@RequestParam String RAddr,
			@RequestParam String RDes,@RequestParam String rpId,@RequestParam String rpName)
	{
		String UId = session.getAttribute("userId").toString();
		
		int repairType  =  1;
		Timestamp RDate = TimeUtil.getTimeNow();
		int i_rpId = 0;
		
		try {
			i_rpId = Integer.parseInt(rpId);
		} catch (Exception e) {
			e.printStackTrace();
			i_rpId = 0;
		}
		Repairs repair = new Repairs(IdProviderUtils.getRepairId(),RTitle, RAddr,RDes, RDate,Constants.REPAIR_WAITE_CHECK,UId,1,repairType,i_rpId,rpName);
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
		
		
		RepairServiceModel model = new RepairServiceModel();
		Users user = userService.getUserById(repair.getUId());
		
		model.setRepair(repair);
		model.setrServce(service);
		model.setUser(user);
		
		return ResponseMapUtil.responseSuccess("success", model);
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
	@ResponseBody
	@RequestMapping(value="/finishRepair",method=RequestMethod.POST)
	public Map<String,Object> finishRepair(@RequestParam String rId){
		//update repair status
		repairService.updateRepairAndService(rId, Constants.REPAIR_COMPLETE);
		return ResponseMapUtil.responseSuccess("success", null);
		
	}
	@ResponseBody
	@RequestMapping(value="/canNotRepair",method=RequestMethod.POST)
	public Map<String,Object> canNotRepair(@RequestParam String rId){
		//update repair status
		repairService.updateRepairAndService(rId, Constants.REPAIR_WORK_REFUSE);
		return ResponseMapUtil.responseSuccess("success", null);
		
	}
	@ResponseBody
	@RequestMapping(value="/getRepairById",method=RequestMethod.POST)
	public Map<String,Object> getRepairById(@RequestParam String rId){
		//update repair status
		Repairs repair = repairService.getRepairById(rId);
		return ResponseMapUtil.responseSuccess("success", repair);
		
	}
	@ResponseBody
	@RequestMapping(value="/getRepairServiceInfo",method=RequestMethod.POST)
	public Map<String,Object> getRepairServiceInfo(@RequestParam String rId){
		RepairServiceModel rsModel =  repairService.getRepairServiceInfo(rId);
		if(rsModel==null){
			return ResponseMapUtil.responseError("error", null);
		}
		else{
			System.out.println("info:"+rsModel.getRepair().getRStatusCode());
			return ResponseMapUtil.responseSuccess("success", rsModel);
			
			 
		}
	}
	
}
