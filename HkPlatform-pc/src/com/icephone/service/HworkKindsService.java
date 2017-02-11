package com.icephone.service;

import java.util.List;

import com.icephone.model.HworkKindModel;

public interface HworkKindsService {

	public HworkKindModel getAllByDate() throws Exception;
	
	public void addWorkKind(String kindType,String kindName) throws Exception;
	
	public void updateWorkKindStatus(String kindId,String status) throws Exception;
}
