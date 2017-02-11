package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * HkWorkers entity. @author MyEclipse Persistence Tools
 */

public class HkWorkers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String userId;
	private String reName;
	private String reCard;
	private Integer workerType;
	private String rePhone;
	private Timestamp reDate;
	private Integer reValid;

	// Constructors

	/** default constructor */
	public HkWorkers() {
	}

	/** minimal constructor */
	public HkWorkers(String userId, String reName, Integer workerType,
			String rePhone, Timestamp reDate, Integer reValid) {
		this.userId = userId;
		this.reName = reName;
		this.workerType = workerType;
		this.rePhone = rePhone;
		this.reDate = reDate;
		this.reValid = reValid;
	}

	/** full constructor */
	public HkWorkers(String userId, String reName, String reCard,
			Integer workerType, String rePhone, Timestamp reDate,
			Integer reValid) {
		this.userId = userId;
		this.reName = reName;
		this.reCard = reCard;
		this.workerType = workerType;
		this.rePhone = rePhone;
		this.reDate = reDate;
		this.reValid = reValid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReName() {
		return this.reName;
	}

	public void setReName(String reName) {
		this.reName = reName;
	}

	public String getReCard() {
		return this.reCard;
	}

	public void setReCard(String reCard) {
		this.reCard = reCard;
	}

	public Integer getWorkerType() {
		return this.workerType;
	}

	public void setWorkerType(Integer workerType) {
		this.workerType = workerType;
	}

	public String getRePhone() {
		return this.rePhone;
	}

	public void setRePhone(String rePhone) {
		this.rePhone = rePhone;
	}

	public Timestamp getReDate() {
		return this.reDate;
	}

	public void setReDate(Timestamp reDate) {
		this.reDate = reDate;
	}

	public Integer getReValid() {
		return this.reValid;
	}

	public void setReValid(Integer reValid) {
		this.reValid = reValid;
	}

}