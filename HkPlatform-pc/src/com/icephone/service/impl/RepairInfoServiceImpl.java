package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RepairInfoDao;
import com.icephone.pojo.RepairsCountInfo;
import com.icephone.service.RepairInfoService;

@Service
public class RepairInfoServiceImpl implements RepairInfoService {
	
	@Autowired
	private RepairInfoDao repairInfoDao;

	@Override
	public List getRepairCountInfo() {
		List list  =  repairInfoDao.getAllRepairInfo();
		if((list==null)||(list.size()==0)){
			return list =  new ArrayList<RepairsCountInfo>();
		}
		return list;
	}
	
	
}
