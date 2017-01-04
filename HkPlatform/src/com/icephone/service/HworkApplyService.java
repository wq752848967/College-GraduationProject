package com.icephone.service;

import com.icephone.model.HkApplyDetial;
import com.icephone.pojo.HkApply;

public interface HworkApplyService {

	public boolean addHworkApply(HkApply hkApply);
	
	public HkApplyDetial getApplyDetial(String hwId);
	
	public boolean updateApply(String hwId,int statusCode);
}
