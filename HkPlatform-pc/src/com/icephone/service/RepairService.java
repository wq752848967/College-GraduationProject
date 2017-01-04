package com.icephone.service;

import java.util.List;

import com.icephone.pojo.Repairs;

public interface RepairService {
	
	public String addRepair(Repairs repairs);
	
	public boolean updateRepaie(String rid,int statusCode);
	
	public Repairs getRepair(int repairType);
	
	public List getByUserId(String userId);
	
	public List getByWorkId(String workId);
	
	public List getAllRepairByDate();
}
