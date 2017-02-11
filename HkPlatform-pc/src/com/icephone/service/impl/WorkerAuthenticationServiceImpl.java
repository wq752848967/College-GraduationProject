package com.icephone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.WorkerAuthenticationDao;
import com.icephone.service.WorkerAuthenticationService;


@Service
public class WorkerAuthenticationServiceImpl implements
		WorkerAuthenticationService {

	@Autowired
	private WorkerAuthenticationDao workerAuthenticationDao;
	@Override
	public List getAllByDate() {
		List list = workerAuthenticationDao.getAllByDate();
		return list;
	}

}
