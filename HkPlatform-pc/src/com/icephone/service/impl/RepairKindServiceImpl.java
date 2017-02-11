package com.icephone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RepairInfoDao;
import com.icephone.dao.RepairKindDao;
import com.icephone.pojo.RepairKinds;
import com.icephone.pojo.RepairsCountInfo;
import com.icephone.service.RepairKindService;
import com.icephone.util.TimeUtil;



@Service
public class RepairKindServiceImpl implements RepairKindService {

	
	@Autowired
	private RepairKindDao repairKindDao;
	@Autowired
	private RepairInfoDao repairInfoDao;

	@Override
	public List getAllKinds() {
		List repairKinds = null;
		repairKinds = repairKindDao.getAllKinds();
		return repairKinds;
	}

	@Override
	public void addKind(RepairKinds repairKind) throws Exception{
		
		repairKindDao.add(repairKind);
		RepairsCountInfo countInfo = new RepairsCountInfo(repairKind.getId(), repairKind.getRkName(), 0, 0, TimeUtil.getTimeNow());
		repairInfoDao.add(countInfo);
	}

	@Override
	public void updateRepairKind(String rkId) throws Exception {
		//get 
		
		RepairKinds rk = repairKindDao.getById(RepairKinds.class, Integer.parseInt(rkId));
		rk.setRkValid(2);
		repairKindDao.update(rk);
	}
}
