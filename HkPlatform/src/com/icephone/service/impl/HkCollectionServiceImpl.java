package com.icephone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icephone.dao.HkCollectionDao;
import com.icephone.pojo.HkCollection;
import com.icephone.service.HkCollectionService;


@Service
public class HkCollectionServiceImpl implements HkCollectionService {

	@Autowired
	private HkCollectionDao hkCollectionDao;
	
	
	
	@Override
	public boolean addHkCollection(HkCollection hkCollection) {
		
		hkCollectionDao.add(hkCollection);
		return true;
	}

}
