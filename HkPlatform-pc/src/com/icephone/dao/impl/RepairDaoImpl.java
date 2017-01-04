package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.RepairDao;


@Repository
public class RepairDaoImpl extends BaseDaoImpl implements RepairDao {

	@Override
	public List getByType(int repairType) {
		String hql = "from Repairs where RTypeCode = ? order by RDate asc";
		return this.getHibernateTemplate().find(hql,repairType);
		
	}

	@Override
	public List getByUId(String userId) {
		String hql = "from Repairs where UId = ? order by RDate asc";
		return this.getHibernateTemplate().find(hql,userId);
	}

	@Override
	public List getAllByDate() {
		String hql = "from Repairs order by RDate asc";
		return this.getHibernateTemplate().find(hql);
	}
	
}
