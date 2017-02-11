package com.icephone.model;

import java.util.ArrayList;

import com.icephone.pojo.RepairParts;

public class RepairProject {

	private RepairParts part;
	private ArrayList<String> partNames;
	
	
	public RepairParts getPart() {
		return part;
	}
	public void setPart(RepairParts part) {
		this.part = part;
	}
	public ArrayList<String> getPartNames() {
		return partNames;
	}
	public void setPartNames(ArrayList<String> partNames) {
		this.partNames = partNames;
	}
	
}
