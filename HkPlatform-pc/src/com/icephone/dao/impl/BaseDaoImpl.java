
package com.icephone.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.icephone.dao.BaseDao;

@Repository
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao
{
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}

	// 提供基本增删改查功能
	public void add(Object o)
	{
		this.getHibernateTemplate().save(o);
	}

	public void update(Object o)
	{
		this.getHibernateTemplate().update(o);
		this.getHibernateTemplate().flush();
	}

	public int hqlUpdate(String hql)
	{
		return this.getHibernateTemplate().bulkUpdate(hql);
	}

	public void delete(Object o)
	{
		this.getHibernateTemplate().delete(o);
		this.getHibernateTemplate().flush();
	}

	public <T> T getById(Class<T> clazz, Serializable id)
	{
		return this.getHibernateTemplate().get(clazz, id);
	}

	@Override
	public <T> List<T> getAll(T t, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
