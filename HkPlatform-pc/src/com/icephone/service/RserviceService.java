package com.icephone.service;

import java.util.List;

import com.icephone.model.WorkRecentServiceModel;
import com.icephone.pojo.RService;

public interface RserviceService {
	public boolean addRservice(RService service);
	
	public List<WorkRecentServiceModel> getRecentWorkService(String userId) throws Exception;
}
