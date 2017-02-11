package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.RepairPartsDao;


@Repository
public class RepairPartsDaoImpl extends BaseDaoImpl implements RepairPartsDao {

	@Override
	public List getAllParts() {
		String hql = "from RepairParts where rpValid=1 order by rpDate asc";
		return this.getHibernateTemplate().find(hql);
	}

}
