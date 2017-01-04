package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.RepairInfoDao;


@Repository
public class RepairInfoDaoImpl extends BaseDaoImpl implements RepairInfoDao {

	@Override
	public List getAllRepairInfo() {
		String hql = "From RepairsCountInfo";
		return this.getHibernateTemplate().find(hql);
	}

}
