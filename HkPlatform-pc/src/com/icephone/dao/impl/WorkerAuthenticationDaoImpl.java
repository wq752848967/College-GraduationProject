package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.WorkerAuthenticationDao;


@Repository
public class WorkerAuthenticationDaoImpl extends BaseDaoImpl implements
		WorkerAuthenticationDao {

	@Override
	public List getAllByDate() {
		String hql = "from WorkerAuthentication order by waDate asc";
		return this.getHibernateTemplate().find(hql);
	}

}
