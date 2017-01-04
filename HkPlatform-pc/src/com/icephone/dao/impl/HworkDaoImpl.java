package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.HworkDao;
import com.icephone.pojo.Hworks;
import com.icephone.util.Constants;


@Repository
public class HworkDaoImpl extends BaseDaoImpl implements HworkDao {

	@Override
	public List findAllHworks() {
		String hql = "from Hworks where hwStatusCode= ? ";
		List result = this.getHibernateTemplate().find(hql,Constants.HWORK_STATUS_USEFUL);
		return result;
	}

	@Override
	public List findHworkListByUId(String UId) {
		
		String hql = "from Hworks where hwPubUId= ? ";
		List result = this.getHibernateTemplate().find(hql,UId);
		return result;
	}

	@Override
	public List getAllByDate() {
		String hql = "from Hworks order by hwPubDate desc ";
		return  this.getHibernateTemplate().find(hql);
	}

	@Override
	public List getAllByStatus(int status) {
		String hql = "from Hworks where hwStatusCode= ? order by hwPubDate desc";
		List result = this.getHibernateTemplate().find(hql,status);
		return result;
	}

	

	
}
