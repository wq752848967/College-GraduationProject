package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.OrdersDao;

@Repository
public class OrdersDaoImpl extends BaseDaoImpl implements OrdersDao {

	@Override
	public List getOrderByWorkerId(String workId) {
		String hql = "From Orders where UWorkId = ?";
		
		return this.getHibernateTemplate().find(hql,workId);
	}

	@Override
	public List getOrderByHwId(String hwId) {
		String hql = "From Orders where UHworkId = ?";
		
		return this.getHibernateTemplate().find(hql,hwId);
	}

}
