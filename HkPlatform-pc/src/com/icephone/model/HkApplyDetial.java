package com.icephone.model;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.icephone.pojo.Hworks;

public class HkApplyDetial {

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
	private ArrayList<GenApplyer> applyers;
	public HkApplyDetial(String hwId, String hwPubUId, String hwTitle,
			Double hwMoney, String hwDate, Integer hwTime, Timestamp hwPubDate,
			Integer hwVisitTime, Integer hwApplyAmount, String hwAddr,
			Integer hwTypeCode, Integer hwDTypeCode, String hwDesc,
			Integer hwStatusCode, ArrayList<GenApplyer> applyers) {
		super();
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
		this.applyers = applyers;
	}
	
	public HkApplyDetial() {
		super();
	}
	public HkApplyDetial(Hworks work) {
		super();
		this.hwId = work.getHwId();
		this.hwPubUId = work.getHwPubUId();
		this.hwTitle = work.getHwTitle();
		this.hwMoney = work.getHwMoney();
		this.hwDate = work.getHwDate();
		this.hwTime = work.getHwTime();
		this.hwPubDate = work.getHwPubDate();
		this.hwVisitTime = work.getHwVisitTime();
		this.hwApplyAmount = work.getHwApplyAmount();
		this.hwAddr = work.getHwAddr();
		this.hwTypeCode = work.getHwTypeCode();
		this.hwDTypeCode = work.getHwDTypeCode();
		this.hwDesc = work.getHwDesc();
		this.hwStatusCode = work.getHwStatusCode();
	}

	public String getHwId() {
		return hwId;
	}
	public void setHwId(String hwId) {
		this.hwId = hwId;
	}
	public String getHwPubUId() {
		return hwPubUId;
	}
	public void setHwPubUId(String hwPubUId) {
		this.hwPubUId = hwPubUId;
	}
	public String getHwTitle() {
		return hwTitle;
	}
	public void setHwTitle(String hwTitle) {
		this.hwTitle = hwTitle;
	}
	public Double getHwMoney() {
		return hwMoney;
	}
	public void setHwMoney(Double hwMoney) {
		this.hwMoney = hwMoney;
	}
	public String getHwDate() {
		return hwDate;
	}
	public void setHwDate(String hwDate) {
		this.hwDate = hwDate;
	}
	public Integer getHwTime() {
		return hwTime;
	}
	public void setHwTime(Integer hwTime) {
		this.hwTime = hwTime;
	}
	public Timestamp getHwPubDate() {
		return hwPubDate;
	}
	public void setHwPubDate(Timestamp hwPubDate) {
		this.hwPubDate = hwPubDate;
	}
	public Integer getHwVisitTime() {
		return hwVisitTime;
	}
	public void setHwVisitTime(Integer hwVisitTime) {
		this.hwVisitTime = hwVisitTime;
	}
	public Integer getHwApplyAmount() {
		return hwApplyAmount;
	}
	public void setHwApplyAmount(Integer hwApplyAmount) {
		this.hwApplyAmount = hwApplyAmount;
	}
	public String getHwAddr() {
		return hwAddr;
	}
	public void setHwAddr(String hwAddr) {
		this.hwAddr = hwAddr;
	}
	public Integer getHwTypeCode() {
		return hwTypeCode;
	}
	public void setHwTypeCode(Integer hwTypeCode) {
		this.hwTypeCode = hwTypeCode;
	}
	public Integer getHwDTypeCode() {
		return hwDTypeCode;
	}
	public void setHwDTypeCode(Integer hwDTypeCode) {
		this.hwDTypeCode = hwDTypeCode;
	}
	public String getHwDesc() {
		return hwDesc;
	}
	public void setHwDesc(String hwDesc) {
		this.hwDesc = hwDesc;
	}
	public Integer getHwStatusCode() {
		return hwStatusCode;
	}
	public void setHwStatusCode(Integer hwStatusCode) {
		this.hwStatusCode = hwStatusCode;
	}
	public ArrayList<GenApplyer> getApplyers() {
		return applyers;
	}
	public void setApplyers(ArrayList<GenApplyer> applyers) {
		this.applyers = applyers;
	}
	
	
	
}
