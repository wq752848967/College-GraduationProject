package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * HkApply entity. @author MyEclipse Persistence Tools
 */

public class HkApply implements java.io.Serializable {

	// Fields

	private Integer haId;
	private String hwId;
	private String UId;
	private Timestamp haDate;
	private Integer haStatusCode;

	// Constructors

	/** default constructor */
	public HkApply() {
	}

	/** full constructor */
	public HkApply(String hwId, String UId, Timestamp haDate,
			Integer haStatusCode) {
		this.hwId = hwId;
		this.UId = UId;
		this.haDate = haDate;
		this.haStatusCode = haStatusCode;
	}

	// Property accessors

	public Integer getHaId() {
		return this.haId;
	}

	public void setHaId(Integer haId) {
		this.haId = haId;
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

	public Timestamp getHaDate() {
		return this.haDate;
	}

	public void setHaDate(Timestamp haDate) {
		this.haDate = haDate;
	}

	public Integer getHaStatusCode() {
		return this.haStatusCode;
	}

	public void setHaStatusCode(Integer haStatusCode) {
		this.haStatusCode = haStatusCode;
	}

}