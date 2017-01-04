package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * HkCollection entity. @author MyEclipse Persistence Tools
 */

public class HkCollection implements java.io.Serializable {

	// Fields

	private Integer hcId;
	private String hwId;
	private String UId;
	private Timestamp hcDate;
	private Integer hcStatusCode;

	// Constructors

	/** default constructor */
	public HkCollection() {
	}

	/** minimal constructor */
	public HkCollection(String UId, Timestamp hcDate, Integer hcStatusCode) {
		this.UId = UId;
		this.hcDate = hcDate;
		this.hcStatusCode = hcStatusCode;
	}

	/** full constructor */
	public HkCollection(String hwId, String UId, Timestamp hcDate,
			Integer hcStatusCode) {
		this.hwId = hwId;
		this.UId = UId;
		this.hcDate = hcDate;
		this.hcStatusCode = hcStatusCode;
	}

	// Property accessors

	public Integer getHcId() {
		return this.hcId;
	}

	public void setHcId(Integer hcId) {
		this.hcId = hcId;
	}

	public String getHwId() {
		return this.hwId;
	}

	public void setHwId(String hwId) {
		this.hwId = hwId;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public Timestamp getHcDate() {
		return this.hcDate;
	}

	public void setHcDate(Timestamp hcDate) {
		this.hcDate = hcDate;
	}

	public Integer getHcStatusCode() {
		return this.hcStatusCode;
	}

	public void setHcStatusCode(Integer hcStatusCode) {
		this.hcStatusCode = hcStatusCode;
	}

}