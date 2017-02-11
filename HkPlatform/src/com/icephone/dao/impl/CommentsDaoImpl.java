package com.icephone.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.icephone.dao.CommentsDao;


@Repository
public class CommentsDaoImpl extends BaseDaoImpl implements CommentsDao {

	@Override
	public List getCommentByWId(String workId) {
		String queryString = "from Comments where WWId=?";
		return this.getHibernateTemplate().find(queryString,workId);
		
	}

	@Override
	public List getCommentByHwId(String hwId) {
		String queryString = "from Comments where WHwId=?";
		return this.getHibernateTemplate().find(queryString,hwId);
	}

}
