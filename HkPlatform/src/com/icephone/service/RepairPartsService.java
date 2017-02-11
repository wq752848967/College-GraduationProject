package com.icephone.service;

import java.util.List;

import com.icephone.pojo.RepairParts;

public interface RepairPartsService {

	public boolean addParts(RepairParts rPart);
	
	public List getAllParts();
	
	public boolean updatePartsContent(int pId,String pName,String pParts,int pStatus);
}
