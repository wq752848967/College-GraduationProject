package com.icephone.service;

import java.util.List;

import com.icephone.pojo.RepairKinds;

public interface RepairKindService {

	public List getAllKinds();
	public void updateRepairKind(String rkId) throws Exception;
	
	public void addKind(RepairKinds repairKind) throws Exception;
}
