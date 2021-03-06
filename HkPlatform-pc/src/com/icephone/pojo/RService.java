package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * RService entity. @author MyEclipse Persistence Tools
 */

public class RService implements java.io.Serializable {

	// Fields

	private Integer rsId;
	private String RId;
	private String workId;
	private Timestamp rsDate;
	private Integer rsStatusCode;
	private Timestamp rsFinishDate;

	// Constructors

	/** default constructor */
	public RService() {
	}

	/** minimal constructor */
	public RService(String RId, String workId, Timestamp rsDate,
			Integer rsStatusCode) {
		this.RId = RId;
		this.workId = workId;
		this.rsDate = rsDate;
		this.rsStatusCode = rsStatusCode;
	}

	/** full constructor */
	public RService(String RId, String workId, Timestamp rsDate,
			Integer rsStatusCode, Timestamp rsFinishDate) {
		this.RId = RId;
		this.workId = workId;
		this.rsDate = rsDate;
		this.rsStatusCode = rsStatusCode;
		this.rsFinishDate = rsFinishDate;
	}

	// Property accessors

	public Integer getRsId() {
		return this.rsId;
	}

	public void setRsId(Integer rsId) {
		this.rsId = rsId;
	}

	public String getRId() {
		return this.RId;
	}

	public void setRId(String RId) {
		this.RId = RId;
	}

	public String getWorkId() {
		return this.workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public Timestamp getRsDate() {
		return this.rsDate;
	}

	public void setRsDate(Timestamp rsDate) {
		this.rsDate = rsDate;
	}

	public Integer getRsStatusCode() {
		return this.rsStatusCode;
	}

	public void setRsStatusCode(Integer rsStatusCode) {
		this.rsStatusCode = rsStatusCode;
	}

	public Timestamp getRsFinishDate() {
		return this.rsFinishDate;
	}

	public void setRsFinishDate(Timestamp rsFinishDate) {
		this.rsFinishDate = rsFinishDate;
	}

}