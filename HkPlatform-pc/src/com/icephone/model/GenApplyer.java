package com.icephone.model;

import java.sql.Timestamp;

public class GenApplyer {
	private String userId;
	private String name;
	private Timestamp date;
	private double points;
	public GenApplyer(String userId, String name, Timestamp date, double points) {
		super();
		this.userId = userId;
		this.name = name;
		this.date = date;
		this.points = points;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	
	
	
}
