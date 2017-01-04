package com.icephone.dao;



import java.util.List;

import com.icephone.pojo.Hworks;

public interface HworkDao extends BaseDao{

	public List findAllHworks();
	
	public List findHworkListByUId(String UId);
}
