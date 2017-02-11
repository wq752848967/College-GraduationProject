package com.icephone.service;

import java.util.List;

import com.icephone.model.RepairServiceModel;
import com.icephone.pojo.Repairs;

public interface RepairService {
	
	public String addRepair(Repairs repairs);
	
	public boolean updateRepaie(String rid,int statusCode);
	
	public Repairs getRepair(int repairType);
	
	public Repairs getRepairById(String rId);
	
	public List getByUserId(String userId);
	
	public List getByWorkId(String workId);
	
	public List getAllRepairByDate();
	
	public RepairServiceModel getRepairServiceInfo(String rId,String uId);
}
