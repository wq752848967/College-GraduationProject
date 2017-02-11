package com.icephone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.HkWorkersDao;
import com.icephone.dao.WorkerAuthenticationDao;
import com.icephone.pojo.HkWorkers;
import com.icephone.pojo.WorkerAuthentication;
import com.icephone.service.HkWorkersService;
import com.icephone.util.TimeUtil;


@Service
public class HkWorkersServiceImpl implements HkWorkersService {

	
	@Autowired
	private HkWorkersDao hkWorkersDao;
	
	@Autowired
	private WorkerAuthenticationDao workerAuthenticationDao;

	@Override
	public void addHkWorker(HkWorkers worker) throws Exception {
		hkWorkersDao.add(worker);
		
	}

	@Override
	public boolean allowWorkerAu(int waId) throws Exception {
		//update application status 
		WorkerAuthentication wa =  workerAuthenticationDao.getById(WorkerAuthentication.class, waId);
		wa.setWaValid(2);
		workerAuthenticationDao.update(wa);
		//add worker info
		HkWorkers worker = new HkWorkers(wa.getWaUser(), wa.getWaReName()
				, wa.getWaReCard(), wa.getWaWorkerType(), wa.getWaPhone(), 
				TimeUtil.getTimeNow(), 1);
		hkWorkersDao.add(worker);
		
		return true;
	}

	@Override
	public boolean refuseWorkerAu(int waId) throws Exception {
		WorkerAuthentication wa =  workerAuthenticationDao.getById(WorkerAuthentication.class, waId);
		wa.setWaValid(3);
		workerAuthenticationDao.update(wa);
		return true;
	}
	
}
