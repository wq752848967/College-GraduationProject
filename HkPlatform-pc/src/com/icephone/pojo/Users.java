package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private String UId;
	private String UPhone;
	private String UPsw;
	private Timestamp UDate;
	private Double UPoints;
	private Integer UStatusCode;
	private Integer UTypeCode;
	private String UName;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String UId, String UPhone, String UPsw, Timestamp UDate,
			String UName) {
		this.UId = UId;
		this.UPhone = UPhone;
		this.UPsw = UPsw;
		this.UDate = UDate;
		this.UName = UName;
	}

	/** full constructor */
	public Users(String UId, String UPhone, String UPsw, Timestamp UDate,
			Double UPoints, Integer UStatusCode, Integer UTypeCode, String UName) {
		this.UId = UId;
		this.UPhone = UPhone;
		this.UPsw = UPsw;
		this.UDate = UDate;
		this.UPoints = UPoints;
		this.UStatusCode = UStatusCode;
		this.UTypeCode = UTypeCode;
		this.UName = UName;
	}

	// Property accessors

	public String getUId() {
		return this.UId;
	}

	public void setUId(String UId) {
		this.UId = UId;
	}

	public String getUPhone() {
		return this.UPhone;
	}

	public void setUPhone(String UPhone) {
		this.UPhone = UPhone;
	}

	public String getUPsw() {
		return this.UPsw;
	}

	public void setUPsw(String UPsw) {
		this.UPsw = UPsw;
	}

	public Timestamp getUDate() {
		return this.UDate;
	}

	public void setUDate(Timestamp UDate) {
		this.UDate = UDate;
	}

	public Double getUPoints() {
		return this.UPoints;
	}

	public void setUPoints(Double UPoints) {
		this.UPoints = UPoints;
	}

	public Integer getUStatusCode() {
		return this.UStatusCode;
	}

	public void setUStatusCode(Integer UStatusCode) {
		this.UStatusCode = UStatusCode;
	}

	public Integer getUTypeCode() {
		return this.UTypeCode;
	}

	public void setUTypeCode(Integer UTypeCode) {
		this.UTypeCode = UTypeCode;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

}