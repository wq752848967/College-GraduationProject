package com.icephone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RepairWorkerDao;
import com.icephone.pojo.RepairWorks;
import com.icephone.service.RepairWorkerService;
import com.icephone.util.TimeUtil;


@Service
public class RepairWorkerServiceImpl implements RepairWorkerService {

	@Autowired
	private RepairWorkerDao repairWorkerDao;

	@Override
	public String addWorker(String userId, String workType) throws Exception {
		
		RepairWorks worker = new RepairWorks(userId, 0, TimeUtil.getTimeNow(), Integer.parseInt(workType));
		
		repairWorkerDao.add(worker);

		String id = worker.getId()+"";
		return id;
	}
}
