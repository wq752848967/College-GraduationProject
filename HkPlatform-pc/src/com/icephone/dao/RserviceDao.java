package com.icephone.dao;

import java.util.List;

public interface RserviceDao extends BaseDao {

	public List getByUserId(String workId);
}
