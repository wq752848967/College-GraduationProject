package com.icephone.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.management.j2ee.statistics.TimeStatistic;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.pojo.Orders;
import com.icephone.service.HworkApplyService;
import com.icephone.service.HworkService;
import com.icephone.service.OrdersService;
import com.icephone.util.Constants;
import com.icephone.util.IdProviderUtils;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;


@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private HworkService hworkService;
	
	@Autowired
	private HworkApplyService hworkApplyService;
	
	@Autowired
	private HttpSession session;
	
	@ResponseBody
	@RequestMapping(value="/createOrder",method=RequestMethod.POST)
	public Map<String,Object> createOrder(@RequestParam String workId,@RequestParam String hworkId){
		String cusId = session.getAttribute("userId").toString();
		Timestamp order_date = TimeUtil.getTimeNow();
		String order_id = IdProviderUtils.getOrderId();
		int order_status_code = Constants.HWORK_STATUS_WORKING;
		Orders order =  new Orders(order_id,cusId, workId, order_status_code, order_date, hworkId);
		ordersService.addOrder(order);
		//更改原有work的状态
		hworkService.updateHwork(hworkId, order_status_code);
		//更改申请状态
		hworkApplyService.updateApply(hworkId, Constants.HWORK_APPLY_STATUS_SUSPEND);
		return ResponseMapUtil.responseSuccess(order_id, null);
	
	}
	@ResponseBody
	@RequestMapping(value="/completeHwork",method=RequestMethod.POST)
	public Map<String,Object> completeHwork(@RequestParam String hwId){
		boolean result = ordersService.updateCompleteHwork(hwId);
		if(result){
			return ResponseMapUtil.responseSuccess("success", null);
		}
		else{
			return ResponseMapUtil.responseError("error", null);
		}
	}
	
	
}
