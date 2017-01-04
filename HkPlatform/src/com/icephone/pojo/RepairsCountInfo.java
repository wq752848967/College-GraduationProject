package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * RepairsCountInfo entity. @author MyEclipse Persistence Tools
 */

public class RepairsCountInfo implements java.io.Serializable {

	// Fields

	private Integer rcId;
	private Integer rcTypeCode;
	private String rcTypeName;
	private Integer rcUnComplete;
	private Integer rcDayComplete;
	private Timestamp rcUpdateDate;

	// Constructors

	/** default constructor */
	public RepairsCountInfo() {
	}

	/** minimal constructor */
	public RepairsCountInfo(String rcTypeName, Integer rcUnComplete,
			Integer rcDayComplete) {
		this.rcTypeName = rcTypeName;
		this.rcUnComplete = rcUnComplete;
		this.rcDayComplete = rcDayComplete;
	}

	/** full constructor */
	public RepairsCountInfo(Integer rcTypeCode, String rcTypeName,
			Integer rcUnComplete, Integer rcDayComplete, Timestamp rcUpdateDate) {
		this.rcTypeCode = rcTypeCode;
		this.rcTypeName = rcTypeName;
		this.rcUnComplete = rcUnComplete;
		this.rcDayComplete = rcDayComplete;
		this.rcUpdateDate = rcUpdateDate;
	}

	// Property accessors

	public Integer getRcId() {
		return this.rcId;
	}

	public void setRcId(Integer rcId) {
		this.rcId = rcId;
	}

	public Integer getRcTypeCode() {
		return this.rcTypeCode;
	}

	public void setRcTypeCode(Integer rcTypeCode) {
		this.rcTypeCode = rcTypeCode;
	}

	public String getRcTypeName() {
		return this.rcTypeName;
	}

	public void setRcTypeName(String rcTypeName) {
		this.rcTypeName = rcTypeName;
	}

	public Integer getRcUnComplete() {
		return this.rcUnComplete;
	}

	public void setRcUnComplete(Integer rcUnComplete) {
		this.rcUnComplete = rcUnComplete;
	}

	public Integer getRcDayComplete() {
		return this.rcDayComplete;
	}

	public void setRcDayComplete(Integer rcDayComplete) {
		this.rcDayComplete = rcDayComplete;
	}

	public Timestamp getRcUpdateDate() {
		return this.rcUpdateDate;
	}

	public void setRcUpdateDate(Timestamp rcUpdateDate) {
		this.rcUpdateDate = rcUpdateDate;
	}

}