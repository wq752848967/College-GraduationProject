package com.icephone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.HworkDao;
import com.icephone.dao.OrdersDao;
import com.icephone.pojo.Hworks;
import com.icephone.pojo.Orders;
import com.icephone.service.OrdersService;
import com.icephone.util.Constants;


@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private HworkDao hworkDao;
	
	@Override
	public boolean addOrder(Orders order) {
		ordersDao.add(order);
		return true;
	}

	@Override
	public boolean updateCompleteHwork(String hwId) {
		List list = ordersDao.getOrderByHwId(hwId);
		if(list ==  null){
			return false;
		}
		Orders order = ((Orders)list.get(0));
		order.setOrderStatusCode(Constants.HWORK_STATUS_COMMENTS);
		ordersDao.update(order);
		//更新hwork状态
		
		Hworks work = hworkDao.getById(Hworks.class, hwId);
		work.setHwStatusCode(Constants.HWORK_STATUS_COMMENTS);
		hworkDao.update(work);
		return true;
	}
}
