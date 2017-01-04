package com.icephone.dao;

import java.util.List;

public interface RepairDao extends BaseDao{

	public List getByType(int repairType);
	
	public List getByUId(String userId);
	
	public List getAllByDate();
}
