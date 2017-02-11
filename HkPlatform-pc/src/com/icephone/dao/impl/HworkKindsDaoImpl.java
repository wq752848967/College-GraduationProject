package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.HworkKindsDao;



@Repository
public class HworkKindsDaoImpl extends BaseDaoImpl implements HworkKindsDao {

	@Override
	public List getAllByDate(int type) {
		String hql = "from HworkKinds where hwkValid = 1 and hwkType="+type;
		return this.getHibernateTemplate().find(hql);
	}

}
