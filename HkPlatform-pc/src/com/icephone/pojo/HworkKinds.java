package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * HworkKinds entity. @author MyEclipse Persistence Tools
 */

public class HworkKinds implements java.io.Serializable {

	// Fields

	private Integer hwkId;
	private String hwkName;
	private Timestamp hwkDate;
	private Integer hwkValid;
	private Integer hwkType;

	// Constructors

	/** default constructor */
	public HworkKinds() {
	}

	/** full constructor */
	public HworkKinds(String hwkName, Timestamp hwkDate, Integer hwkValid,
			Integer hwkType) {
		this.hwkName = hwkName;
		this.hwkDate = hwkDate;
		this.hwkValid = hwkValid;
		this.hwkType = hwkType;
	}

	// Property accessors

	public Integer getHwkId() {
		return this.hwkId;
	}

	public void setHwkId(Integer hwkId) {
		this.hwkId = hwkId;
	}

	public String getHwkName() {
		return this.hwkName;
	}

	public void setHwkName(String hwkName) {
		this.hwkName = hwkName;
	}

	public Timestamp getHwkDate() {
		return this.hwkDate;
	}

	public void setHwkDate(Timestamp hwkDate) {
		this.hwkDate = hwkDate;
	}

	public Integer getHwkValid() {
		return this.hwkValid;
	}

	public void setHwkValid(Integer hwkValid) {
		this.hwkValid = hwkValid;
	}

	public Integer getHwkType() {
		return this.hwkType;
	}

	public void setHwkType(Integer hwkType) {
		this.hwkType = hwkType;
	}

}