package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * RepairParts entity. @author MyEclipse Persistence Tools
 */

public class RepairParts implements java.io.Serializable {

	// Fields

	private Integer rpId;
	private String rpName;
	private String rpParts;
	private Timestamp rpDate;
	private Integer rpValid;

	// Constructors

	/** default constructor */
	public RepairParts() {
	}

	/** minimal constructor */
	public RepairParts(Timestamp rpDate, Integer rpValid) {
		this.rpDate = rpDate;
		this.rpValid = rpValid;
	}

	/** full constructor */
	public RepairParts(String rpName, String rpParts, Timestamp rpDate,
			Integer rpValid) {
		this.rpName = rpName;
		this.rpParts = rpParts;
		this.rpDate = rpDate;
		this.rpValid = rpValid;
	}

	// Property accessors

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

	public String getRpParts() {
		return this.rpParts;
	}

	public void setRpParts(String rpParts) {
		this.rpParts = rpParts;
	}

	public Timestamp getRpDate() {
		return this.rpDate;
	}

	public void setRpDate(Timestamp rpDate) {
		this.rpDate = rpDate;
	}

	public Integer getRpValid() {
		return this.rpValid;
	}

	public void setRpValid(Integer rpValid) {
		this.rpValid = rpValid;
	}

}