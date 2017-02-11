package com.icephone.controller;

import java.util.Map;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icephone.pojo.HkWorkers;
import com.icephone.service.HkWorkersService;
import com.icephone.util.Constants;
import com.icephone.util.ResponseMapUtil;
import com.icephone.util.TimeUtil;


@Controller
@RequestMapping("/hkworker")
public class HkWorkersController {

	@Autowired
	private HkWorkersService hkWorkersService;
	
	
	/**
	 *   after authoritation,
	 *   add worker into db
	 *   
	 * @param userId
	 * @param reName
	 * @param reCard
	 * @param workerType
	 * @param rePhone
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="/addHkWorker")
	public Map<String,Object> addHkWorker(@RequestParam String userId,
			@RequestParam String reName,@RequestParam String reCard,@RequestParam int workerType
			,@RequestParam String rePhone){
		HkWorkers worker = new HkWorkers(userId, reName, reCard, workerType, rePhone, TimeUtil.getTimeNow(), 1);
		try {
			hkWorkersService.addHkWorker(worker);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", null);
		
		
	}
	@ResponseBody
	@RequestMapping(value="/allowWorkerAu")
	public Map<String,Object> allowWorkerAu(@RequestParam int waId){
		
		try {
			hkWorkersService.allowWorkerAu(waId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", null);
		
		
	}
	@ResponseBody
	@RequestMapping(value="/refuseWorkerAu")
	public Map<String,Object> refuseWorkerAu(@RequestParam int waId){
		
		try {
			hkWorkersService.refuseWorkerAu(waId);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseMapUtil.responseError("error", null);
		}
		return ResponseMapUtil.responseSuccess("success", null);
		
		
	}
}
