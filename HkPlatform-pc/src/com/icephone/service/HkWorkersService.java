package com.icephone.service;

import com.icephone.pojo.HkWorkers;

public interface HkWorkersService {

	public void addHkWorker(HkWorkers worker) throws Exception;
	
	public boolean allowWorkerAu(int waId) throws Exception;
	
	public boolean refuseWorkerAu(int waId) throws Exception;
}
