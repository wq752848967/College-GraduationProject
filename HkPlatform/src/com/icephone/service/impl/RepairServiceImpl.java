package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RepairDao;
import com.icephone.dao.RserviceDao;
import com.icephone.dao.UserDao;
import com.icephone.model.RepairServiceModel;
import com.icephone.pojo.RService;
import com.icephone.pojo.Repairs;
import com.icephone.pojo.Users;
import com.icephone.service.RepairService;
import com.icephone.util.Constants;
import com.icephone.util.TimeUtil;


@Service
public class RepairServiceImpl implements RepairService {

	@Autowired
	private RepairDao repairDao;
	
	@Autowired
	private RserviceDao rserviceDao;
	
	@Autowired
	private UserDao userDao;
	@Override
	public String addRepair(Repairs repairs) {
		String result = "";
		/*  check if the params is correct */
		//check userId
		Users user = userDao.getUserById(repairs.getUId());
		if((user==null)||(user.getUStatusCode()==Constants.USER_STATUS_PROHIBIT))
		{
			result = Constants.USER_STSTUS_NOT_NOMAL;
			return result;
		}
		//save repairs
		repairDao.add(repairs);
		
		
		//update repair count  info
		
				//need
		
		return "success";
	}
	@Override
	public boolean updateRepaie(String rid, int statusCode) {
		Repairs repairs  = repairDao.getById(Repairs.class, rid);
		if(repairs==null){
			return false;
		}
		repairs.setRStatusCode(statusCode);
		repairDao.update(repairs);
		return true;
	}
	@Override
	public Repairs getRepair(int repairType) {
		Repairs repairResult = null;
		List listResult = repairDao.getByType(repairType);
		if((listResult==null)||(listResult.size()==0)){
			return repairResult;
		}
		repairResult  =  (Repairs)(listResult.get(0));
		return repairResult;
	}
	@Override
	public List getByUserId(String userId) {
		List listResult = repairDao.getByUId(userId);
		if(listResult==null){
			listResult = new ArrayList<Repairs>();
		}
		return listResult;
	}
	@Override
	public List getByWorkId(String workId) {
		List resultList = new ArrayList<Repairs>();
		List rserviceList = rserviceDao.getByUserId(workId);
		
		if((rserviceList==null)||(rserviceList.size()==0)){
			return resultList;
		}
		for(int i=0;i<rserviceList.size();i++){
			RService service = (RService)rserviceList.get(i);
			String rId = service.getRId();
			Repairs repair = repairDao.getById(Repairs.class, rId);
			resultList.add(repair);
		}
		return resultList;
	}
	@Override
	public Repairs getRepairById(String rId) {
		return repairDao.getById(Repairs.class, rId);
		
		
	}
	@Override
	public RepairServiceModel getRepairServiceInfo(String rId) {
		RepairServiceModel repairModel = new RepairServiceModel();
		Repairs repair = repairDao.getById(Repairs.class, rId);
		System.out.println("status:"+repair.getRStatusCode());
		
		Users user = userDao.getUserById(repair.getUId()); //
		List rsList = rserviceDao.getByRepairId(rId);
		if((rsList==null)||(rsList.size()==0)){
			repairModel.setrServce(null);
			repairModel.setUser(user);
			repairModel.setWorker(null);
			repairModel.setRepair(repair);
		}
		else{
			RService rService = (RService)rsList.get(0);//
			Users worker = userDao.getUserById(rService.getWorkId());
			repairModel.setrServce(rService);
			repairModel.setUser(user);
			repairModel.setWorker(worker);
			repairModel.setRepair(repair);
		}
		
		
		
		return repairModel;
	}
	@Override
	public boolean updateRepairAndService(String rid, int statusCode) {
		Repairs repairs  = repairDao.getById(Repairs.class, rid);
		if(repairs==null){
			return false;
		}
		repairs.setRStatusCode(statusCode);
		repairDao.update(repairs);
		
		List list = rserviceDao.getByRepairId(rid);
		if((list==null)||(list.size()==0)){
			return true;
		}
		RService rservice = (RService)list.get(0);
		rservice.setRsFinishDate(TimeUtil.getTimeNow());
		rserviceDao.update(rservice);
		return true;
	}
}
