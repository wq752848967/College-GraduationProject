package com.icephone.dao;

import java.util.List;

public interface HworkApplyDao extends BaseDao {

	public List getListByHwId(String hwId);
}
