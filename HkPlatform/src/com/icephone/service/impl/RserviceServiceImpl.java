package com.icephone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.RserviceDao;
import com.icephone.pojo.RService;
import com.icephone.service.RserviceService;



@Service
public class RserviceServiceImpl implements RserviceService {

	@Autowired
	private RserviceDao rserviceDao; 
	
	
	@Override
	public boolean addRservice(RService service) {
		rserviceDao.add(service);
		return true;
	}

	
}
