package com.icephone.model;

import com.icephone.pojo.RepairWorks;
import com.icephone.pojo.Users;

public class WorkerModel {

	private Users user=  null;
	private RepairWorks worker = null;
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public RepairWorks getWorker() {
		return worker;
	}
	public void setWorker(RepairWorks worker) {
		this.worker = worker;
	}
	
	
}
