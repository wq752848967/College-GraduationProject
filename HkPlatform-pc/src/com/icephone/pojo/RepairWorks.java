package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * RepairWorks entity. @author MyEclipse Persistence Tools
 */

public class RepairWorks implements java.io.Serializable {

	// Fields

	private Integer id;
	private String UId;
	private Integer tdWorkCount;
	private Timestamp tdWorkDate;
	private Integer rwType;

	// Constructors

	/** default constructor */
	public RepairWorks() {
	}

	/** minimal constructor */
	public RepairWorks(Integer tdWorkCount, Timestamp tdWorkDate) {
		this.tdWorkCount = tdWorkCount;
		this.tdWorkDate = tdWorkDate;
	}

	/** full constructor */
	public RepairWorks(String UId, Integer tdWorkCount, Timestamp tdWorkDate,
			Integer rwType) {
		this.UId = UId;
		this.tdWorkCount = tdWorkCount;
		this.tdWorkDate = tdWorkDate;
		this.rwType = rwType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public Integer getTdWorkCount() {
		return this.tdWorkCount;
	}

	public void setTdWorkCount(Integer tdWorkCount) {
		this.tdWorkCount = tdWorkCount;
	}

	public Timestamp getTdWorkDate() {
		return this.tdWorkDate;
	}

	public void setTdWorkDate(Timestamp tdWorkDate) {
		this.tdWorkDate = tdWorkDate;
	}

	public Integer getRwType() {
		return this.rwType;
	}

	public void setRwType(Integer rwType) {
		this.rwType = rwType;
	}

}