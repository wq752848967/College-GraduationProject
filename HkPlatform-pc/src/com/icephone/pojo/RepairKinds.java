package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * RepairKinds entity. @author MyEclipse Persistence Tools
 */

public class RepairKinds implements java.io.Serializable {

	// Fields

	private Integer id;
	private String rkName;
	private Timestamp rkDate;
	private Integer rkValid;

	// Constructors

	/** default constructor */
	public RepairKinds() {
	}

	/** full constructor */
	public RepairKinds(String rkName, Timestamp rkDate, Integer rkValid) {
		this.rkName = rkName;
		this.rkDate = rkDate;
		this.rkValid = rkValid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRkName() {
		return this.rkName;
	}

	public void setRkName(String rkName) {
		this.rkName = rkName;
	}

	public Timestamp getRkDate() {
		return this.rkDate;
	}

	public void setRkDate(Timestamp rkDate) {
		this.rkDate = rkDate;
	}

	public Integer getRkValid() {
		return this.rkValid;
	}

	public void setRkValid(Integer rkValid) {
		this.rkValid = rkValid;
	}

}