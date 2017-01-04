package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.HworkApplyDao;
import com.icephone.dao.HworkDao;
import com.icephone.dao.UserDao;
import com.icephone.model.GenApplyer;
import com.icephone.model.HkApplyDetial;
import com.icephone.pojo.HkApply;
import com.icephone.pojo.Hworks;
import com.icephone.pojo.Users;
import com.icephone.service.HworkApplyService;


@Service
public class HworkApplyServiceImpl implements HworkApplyService {

	
	
	@Autowired
	private HworkApplyDao happlyDao;
	@Autowired
	private HworkDao hworkDao;
	
	@Autowired
	private UserDao  userDao;
	
	@Override
	public boolean addHworkApply(HkApply hkApply) {
		happlyDao.add(hkApply);
		return true;
	}

	@Override
	public HkApplyDetial getApplyDetial(String hwId) {
		
		
		
		//先获取详细信息
		Hworks hwork = hworkDao.getById(Hworks.class, hwId);
		
		//在获取申请者列表
		List<HkApply> applyList = happlyDao.getListByHwId(hwId);
		
		
		//初始化数据
		HkApplyDetial applyDetial = new HkApplyDetial(hwork);
		ArrayList<GenApplyer> list = new ArrayList<GenApplyer>();
		for(int i=0;i<applyList.size();i++)
		{
			HkApply apply = applyList.get(i);
			Users user = userDao.getUserById(apply.getUId());
			GenApplyer applyer = new GenApplyer(user.getUId(),user.getUName(), apply.getHaDate(), user.getUPoints());
			list.add(applyer);
		}
		applyDetial.setApplyers(list);
		
		
		
		return applyDetial;
	}

	@Override
	public boolean updateApply(String hwId, int statusCode) {
		List applyList = happlyDao.getListByHwId(hwId);
		HkApply apply = null;
		for(int i=0;i<applyList.size();i++){
			apply = (HkApply)applyList.get(i);
			apply.setHaStatusCode(statusCode);
			happlyDao.update(apply);
		}
		return true;
	}
}
