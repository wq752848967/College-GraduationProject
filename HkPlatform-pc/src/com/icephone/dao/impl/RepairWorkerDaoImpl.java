package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.RepairWorkerDao;
import com.icephone.pojo.RepairWorks;

@Repository
public class RepairWorkerDaoImpl extends BaseDaoImpl implements RepairWorkerDao {

	@Override
	public RepairWorks getByUserId(String userId) {
		String hql = "from RepairWorks where UId = ?";
		List list = this.getHibernateTemplate().find(hql,userId);
		if((list==null)||(list.size()==0)){
			return null;
		}
		else{
			return (RepairWorks)list.get(0);
		}
		
	}

}
