package com.icephone.service;

import com.icephone.pojo.Orders;

public interface OrdersService {

	public boolean addOrder(Orders order);
	public boolean updateCompleteHwork(String hwId);
}
