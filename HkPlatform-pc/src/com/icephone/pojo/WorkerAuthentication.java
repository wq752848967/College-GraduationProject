package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * WorkerAuthentication entity. @author MyEclipse Persistence Tools
 */

public class WorkerAuthentication implements java.io.Serializable {

	// Fields

	private Integer waId;
	private String waReName;
	private String waReCard;
	private Integer waWorkerType;
	private String waDesc;
	private Timestamp waDate;
	private Integer waValid;
	private String waPhone;
	private String waUser;
	private String waNumId;

	// Constructors

	/** default constructor */
	public WorkerAuthentication() {
	}

	/** full constructor */
	public WorkerAuthentication(String waReName, String waReCard,
			Integer waWorkerType, String waDesc, Timestamp waDate,
			Integer waValid, String waPhone, String waUser, String waNumId) {
		this.waReName = waReName;
		this.waReCard = waReCard;
		this.waWorkerType = waWorkerType;
		this.waDesc = waDesc;
		this.waDate = waDate;
		this.waValid = waValid;
		this.waPhone = waPhone;
		this.waUser = waUser;
		this.waNumId = waNumId;
	}

	// Property accessors

	public Integer getWaId() {
		return this.waId;
	}

	public void setWaId(Integer waId) {
		this.waId = waId;
	}

	public String getWaReName() {
		return this.waReName;
	}

	public void setWaReName(String waReName) {
		this.waReName = waReName;
	}

	public String getWaReCard() {
		return this.waReCard;
	}

	public void setWaReCard(String waReCard) {
		this.waReCard = waReCard;
	}

	public Integer getWaWorkerType() {
		return this.waWorkerType;
	}

	public void setWaWorkerType(Integer waWorkerType) {
		this.waWorkerType = waWorkerType;
	}

	public String getWaDesc() {
		return this.waDesc;
	}

	public void setWaDesc(String waDesc) {
		this.waDesc = waDesc;
	}

	public Timestamp getWaDate() {
		return this.waDate;
	}

	public void setWaDate(Timestamp waDate) {
		this.waDate = waDate;
	}

	public Integer getWaValid() {
		return this.waValid;
	}

	public void setWaValid(Integer waValid) {
		this.waValid = waValid;
	}

	public String getWaPhone() {
		return this.waPhone;
	}

	public void setWaPhone(String waPhone) {
		this.waPhone = waPhone;
	}

	public String getWaUser() {
		return this.waUser;
	}

	public void setWaUser(String waUser) {
		this.waUser = waUser;
	}

	public String getWaNumId() {
		return this.waNumId;
	}

	public void setWaNumId(String waNumId) {
		this.waNumId = waNumId;
	}

}