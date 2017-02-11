package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RepairDao;
import com.icephone.dao.RserviceDao;
import com.icephone.model.WorkRecentServiceModel;
import com.icephone.pojo.RService;
import com.icephone.pojo.Repairs;
import com.icephone.service.RepairService;
import com.icephone.service.RserviceService;



@Service
public class RserviceServiceImpl implements RserviceService {

	@Autowired
	private RserviceDao rserviceDao; 
	
	@Autowired
	private RepairDao repairDao; 
	
	
	@Override
	public boolean addRservice(RService service) {
		rserviceDao.add(service);
		return true;
	}


	@Override
	public List<WorkRecentServiceModel> getRecentWorkService(String userId)throws Exception {
	List<WorkRecentServiceModel> resultList = new ArrayList<WorkRecentServiceModel>();
	//get rservice
	List<RService> rServiceList = rserviceDao.getByUserId(userId);
	if((rServiceList==null)||(rServiceList.size()==0)){
		return resultList;
	}
	for (RService rService : rServiceList) {
		WorkRecentServiceModel wmodel = new WorkRecentServiceModel();
		Repairs repair = repairDao.getById(Repairs.class, rService.getRId()); 
		wmodel.setRepairs(repair);
		wmodel.setrService(rService);
		resultList.add(wmodel);
	}
	return resultList;
	}

	
}
