package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * Repairs entity. @author MyEclipse Persistence Tools
 */

public class Repairs implements java.io.Serializable {

	// Fields

	private String RId;
	private String RTitle;
	private String RAddr;
	private String RDes;
	private Timestamp RDate;
	private Integer RStatusCode;
	private String UId;
	private Integer RLevel;
	private Integer RTypeCode;
	private Integer rpId;
	private String rpName;

	// Constructors

	/** default constructor */
	public Repairs() {
	}

	/** minimal constructor */
	public Repairs(String RId, String RTitle, String RAddr, Timestamp RDate,
			Integer RStatusCode, String UId, Integer RLevel) {
		this.RId = RId;
		this.RTitle = RTitle;
		this.RAddr = RAddr;
		this.RDate = RDate;
		this.RStatusCode = RStatusCode;
		this.UId = UId;
		this.RLevel = RLevel;
	}

	/** full constructor */
	public Repairs(String RId, String RTitle, String RAddr, String RDes,
			Timestamp RDate, Integer RStatusCode, String UId, Integer RLevel,
			Integer RTypeCode, Integer rpId, String rpName) {
		this.RId = RId;
		this.RTitle = RTitle;
		this.RAddr = RAddr;
		this.RDes = RDes;
		this.RDate = RDate;
		this.RStatusCode = RStatusCode;
		this.UId = UId;
		this.RLevel = RLevel;
		this.RTypeCode = RTypeCode;
		this.rpId = rpId;
		this.rpName = rpName;
	}

	// Property accessors

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getRTitle() {
		return this.RTitle;
	}

	public void setRTitle(String RTitle) {
		this.RTitle = RTitle;
	}

	public String getRAddr() {
		return this.RAddr;
	}

	public void setRAddr(String RAddr) {
		this.RAddr = RAddr;
	}

	public String getRDes() {
		return this.RDes;
	}

	public void setRDes(String RDes) {
		this.RDes = RDes;
	}

	public Timestamp getRDate() {
		return this.RDate;
	}

	public void setRDate(Timestamp RDate) {
		this.RDate = RDate;
	}

	public Integer getRStatusCode() {
		return this.RStatusCode;
	}

	public void setRStatusCode(Integer RStatusCode) {
		this.RStatusCode = RStatusCode;
	}

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public Integer getRLevel() {
		return this.RLevel;
	}

	public void setRLevel(Integer RLevel) {
		this.RLevel = RLevel;
	}

	public Integer getRTypeCode() {
		return this.RTypeCode;
	}

	public void setRTypeCode(Integer RTypeCode) {
		this.RTypeCode = RTypeCode;
	}

	public Integer getRpId() {
		return this.rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	public String getRpName() {
		return this.rpName;
	}

	public void setRpName(String rpName) {
		this.rpName = rpName;
	}

}