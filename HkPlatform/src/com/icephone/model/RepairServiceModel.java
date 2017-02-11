package com.icephone.model;

import com.icephone.pojo.RService;
import com.icephone.pojo.Repairs;
import com.icephone.pojo.Users;

public class RepairServiceModel {

	private Users user;
	private Users worker;
	private Repairs repair;
	private RService rServce;
	
	
	
	public Repairs getRepair() {
		return repair;
	}
	public void setRepair(Repairs repair) {
		this.repair = repair;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Users getWorker() {
		return worker;
	}
	public void setWorker(Users worker) {
		this.worker = worker;
	}
	public RService getrServce() {
		return rServce;
	}
	public void setrServce(RService rServce) {
		this.rServce = rServce;
	}
	
}	
