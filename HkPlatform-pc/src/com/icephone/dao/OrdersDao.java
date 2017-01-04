package com.icephone.dao;

import java.util.List;

public interface OrdersDao extends BaseDao {

	public List getOrderByWorkerId(String workId);
	
	public List getOrderByHwId(String hwId);
}
