package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * Hworks entity. @author MyEclipse Persistence Tools
 */

public class Hworks implements java.io.Serializable {

	// Fields

	private String hwId;
	private String hwPubUId;
	private String hwTitle;
	private Double hwMoney;
	private String hwDate;
	private Integer hwTime;
	private Timestamp hwPubDate;
	private Integer hwVisitTime;
	private Integer hwApplyAmount;
	private String hwAddr;
	private Integer hwTypeCode;
	private Integer hwDTypeCode;
	private String hwDesc;
	private Integer hwStatusCode;

	// Constructors

	/** default constructor */
	public Hworks() {
	}

	/** minimal constructor */
	public Hworks(String hwId, String hwPubUId, String hwTitle, Double hwMoney,
			String hwDate, Timestamp hwPubDate, String hwAddr,
			Integer hwTypeCode, Integer hwDTypeCode, Integer hwStatusCode) {
		this.hwId = hwId;
		this.hwPubUId = hwPubUId;
		this.hwTitle = hwTitle;
		this.hwMoney = hwMoney;
		this.hwDate = hwDate;
		this.hwPubDate = hwPubDate;
		this.hwAddr = hwAddr;
		this.hwTypeCode = hwTypeCode;
		this.hwDTypeCode = hwDTypeCode;
		this.hwStatusCode = hwStatusCode;
	}

	/** full constructor */
	public Hworks(String hwId, String hwPubUId, String hwTitle, Double hwMoney,
			String hwDate, Integer hwTime, Timestamp hwPubDate,
			Integer hwVisitTime, Integer hwApplyAmount, String hwAddr,
			Integer hwTypeCode, Integer hwDTypeCode, String hwDesc,
			Integer hwStatusCode) {
		this.hwId = hwId;
		this.hwPubUId = hwPubUId;
		this.hwTitle = hwTitle;
		this.hwMoney = hwMoney;
		this.hwDate = hwDate;
		this.hwTime = hwTime;
		this.hwPubDate = hwPubDate;
		this.hwVisitTime = hwVisitTime;
		this.hwApplyAmount = hwApplyAmount;
		this.hwAddr = hwAddr;
		this.hwTypeCode = hwTypeCode;
		this.hwDTypeCode = hwDTypeCode;
		this.hwDesc = hwDesc;
		this.hwStatusCode = hwStatusCode;
	}

	// Property accessors

	public String getHwId() {
		return this.hwId;
	}

	public void setHwId(String hwId) {
		this.hwId = hwId;
	}

	public String getHwPubUId() {
		return this.hwPubUId;
	}

	public void setHwPubUId(String hwPubUId) {
		this.hwPubUId = hwPubUId;
	}

	public String getHwTitle() {
		return this.hwTitle;
	}

	public void setHwTitle(String hwTitle) {
		this.hwTitle = hwTitle;
	}

	public Double getHwMoney() {
		return this.hwMoney;
	}

	public void setHwMoney(Double hwMoney) {
		this.hwMoney = hwMoney;
	}

	public String getHwDate() {
		return this.hwDate;
	}

	public void setHwDate(String hwDate) {
		this.hwDate = hwDate;
	}

	public Integer getHwTime() {
		return this.hwTime;
	}

	public void setHwTime(Integer hwTime) {
		this.hwTime = hwTime;
	}

	public Timestamp getHwPubDate() {
		return this.hwPubDate;
	}

	public void setHwPubDate(Timestamp hwPubDate) {
		this.hwPubDate = hwPubDate;
	}

	public Integer getHwVisitTime() {
		return this.hwVisitTime;
	}

	public void setHwVisitTime(Integer hwVisitTime) {
		this.hwVisitTime = hwVisitTime;
	}

	public Integer getHwApplyAmount() {
		return this.hwApplyAmount;
	}

	public void setHwApplyAmount(Integer hwApplyAmount) {
		this.hwApplyAmount = hwApplyAmount;
	}

	public String getHwAddr() {
		return this.hwAddr;
	}

	public void setHwAddr(String hwAddr) {
		this.hwAddr = hwAddr;
	}

	public Integer getHwTypeCode() {
		return this.hwTypeCode;
	}

	public void setHwTypeCode(Integer hwTypeCode) {
		this.hwTypeCode = hwTypeCode;
	}

	public Integer getHwDTypeCode() {
		return this.hwDTypeCode;
	}

	public void setHwDTypeCode(Integer hwDTypeCode) {
		this.hwDTypeCode = hwDTypeCode;
	}

	public String getHwDesc() {
		return this.hwDesc;
	}

	public void setHwDesc(String hwDesc) {
		this.hwDesc = hwDesc;
	}

	public Integer getHwStatusCode() {
		return this.hwStatusCode;
	}

	public void setHwStatusCode(Integer hwStatusCode) {
		this.hwStatusCode = hwStatusCode;
	}

}