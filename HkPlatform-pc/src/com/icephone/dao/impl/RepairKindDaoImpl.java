package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.RepairKindDao;


@Repository
public class RepairKindDaoImpl extends BaseDaoImpl implements RepairKindDao {

	@Override
	public List getAllKinds() {
		String hql = "from RepairKinds where rkValid = 1";
		
		return this.getHibernateTemplate().find(hql);
	}

}
