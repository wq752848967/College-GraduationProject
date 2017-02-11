package com.icephone.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.HworkKindsDao;
import com.icephone.model.HworkKindModel;
import com.icephone.pojo.HworkKinds;
import com.icephone.service.HworkKindsService;
import com.icephone.util.TimeUtil;


@Service
public class HworkKindsServiceImpl implements HworkKindsService {

	
	
	@Autowired
	private HworkKindsDao hworkKindsDao;

	@Override
	public HworkKindModel getAllByDate() throws Exception {
		HworkKindModel model = new HworkKindModel();
		List repairList = hworkKindsDao.getAllByDate(1);
		List sweapList = hworkKindsDao.getAllByDate(2);
		List careList = hworkKindsDao.getAllByDate(3);
		List otherList = hworkKindsDao.getAllByDate(4);
		
		model.setCareList(careList);
		model.setOtherList(otherList);
		model.setRepairList(repairList);
		model.setSweapList(sweapList);
		return model;
	}

	@Override
	public void addWorkKind(String kindType, String kindName) throws Exception {
		HworkKinds kind = new HworkKinds(kindName, TimeUtil.getTimeNow()
				, 1, Integer.parseInt(kindType));
		hworkKindsDao.add(kind);
		
	}

	@Override
	public void updateWorkKindStatus(String kindId,String status) throws Exception {
		HworkKinds kind = hworkKindsDao.getById(HworkKinds.class,Integer.parseInt(kindId));
		kind.setHwkValid(Integer.parseInt(status));
		hworkKindsDao.update(kind);
		
	}
}
