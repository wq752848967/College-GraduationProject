package com.icephone.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.HworkDao;
import com.icephone.dao.OrdersDao;
import com.icephone.dao.UserDao;
import com.icephone.pojo.Hworks;
import com.icephone.pojo.Orders;
import com.icephone.pojo.Users;
import com.icephone.service.HworkService;
import com.icephone.util.Constants;

@Service
public class HworkServiceImpl implements HworkService {
	
	@Autowired
	private HworkDao hwDao;
	
	@Autowired 
	private UserDao userDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	public String addHwork(Hworks hworks)
	{
		String result = "";
	
		/* check if hwork params is correct */
		//check money
		if(hworks.getHwMoney()<0)
		{
			result = Constants.HWORK_INFO_ERROR;
			return result;
		}
		//check userId
		Users user = userDao.getUserById(hworks.getHwPubUId());
		if((user==null)||(user.getUStatusCode()==Constants.USER_STATUS_PROHIBIT))
		{
			result = Constants.USER_STSTUS_NOT_NOMAL;
			return result;
		}
		
		hwDao.add(hworks);
		return "success";
	}
	
	
	
	@Override
	public List getAllHworks() {
		List<Hworks> resultList = new ArrayList<Hworks>();
		resultList = hwDao.findAllHworks();
		
		return resultList;
	}
	
	
	
	@Override
	public Hworks getHworkById(String hwId) {
		
		return hwDao.getById(Hworks.class, hwId);
	}



	@Override
	public List getHworksByUId(String UId) {
		return hwDao.findHworkListByUId(UId);
	}



	@Override
	public boolean updateHwork(String hwId, int statusCode) {
		
		//先获取
		Hworks work = hwDao.getById(Hworks.class,hwId);
		
		//后更新
		work.setHwStatusCode(statusCode);
		//更新持久数据
		hwDao.update(work);
		return true;
	}



	@Override
	public List getHworkByOrder(String userId) {
		
		List<Hworks> resultList  = new ArrayList<Hworks>();
		List orderList  = ordersDao.getOrderByWorkerId(userId);
		if((orderList==null)||(orderList.size()==0)){
			return resultList;
		}
		for(int i=0;i<orderList.size();i++){
			String hwId = ((Orders)orderList.get(i)).getUHworkId();
			Hworks work = hwDao.getById(Hworks.class, hwId);
			resultList.add(work);
		}
		return resultList;
	}
}
