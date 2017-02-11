package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.RserviceDao;

@Repository
public class RserviceDaoImpl extends BaseDaoImpl implements RserviceDao {

	@Override
	public List getByUserId(String workId) {
		String hql = "from RService where workId = ? order by rsDate asc";
		return this.getHibernateTemplate().find(hql,workId);
		
	}

	@Override
	public List getByRepairId(String repairId) {
		
		String hql = "from RService where RId = ?";
		return this.getHibernateTemplate().find(hql,repairId);
	}

}
