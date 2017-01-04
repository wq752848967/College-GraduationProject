package com.icephone.dao;

import java.util.List;

public interface CommentsDao extends BaseDao {

	public List getCommentByWId(String workId);
}
