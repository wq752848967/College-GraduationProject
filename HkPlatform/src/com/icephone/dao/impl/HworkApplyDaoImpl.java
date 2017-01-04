package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.HworkApplyDao;


@Repository
public class HworkApplyDaoImpl extends BaseDaoImpl implements HworkApplyDao {

	@Override
	public List getListByHwId(String hwId) {
		String queryString = "from HkApply where hwId = ?";
		return this.getHibernateTemplate().find(queryString,hwId);
		
	}

}
