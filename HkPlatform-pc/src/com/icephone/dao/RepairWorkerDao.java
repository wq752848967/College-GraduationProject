package com.icephone.dao;

import com.icephone.pojo.RepairWorks;

public interface RepairWorkerDao extends BaseDao {

	public RepairWorks getByUserId(String userId);
}
