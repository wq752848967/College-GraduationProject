package com.icephone.service;

import java.util.List;

import com.icephone.pojo.Hworks;

public interface HworkService {

	public String addHwork(Hworks hworks);
	
	public Hworks getHworkById(String hwId);
	
	public List getAllByDate();
	
	public List getAllByStatus(int status);
	
	public List getAllHworks();
	
	public List getHworksByUId(String UId);
	
	public boolean updateHwork(String hwId,int statusCode);
	
	public List getHworkByOrder(String userId);
}
