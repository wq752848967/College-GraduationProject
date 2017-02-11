package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * Comments entity. @author MyEclipse Persistence Tools
 */

public class Comments implements java.io.Serializable {

	// Fields

	private Integer wcId;
	private String WUId;
	private String wcContent;
	private Double wcPoints;
	private Timestamp wcDate;
	private String WUName;
	private String WWId;
	private String WHwId;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(String WUId, String wcContent, Double wcPoints, Timestamp wcDate,
			String WUName, String WWId) {
		this.wcContent = wcContent;
		this.WUId = WUId;
		this.wcPoints = wcPoints;
		this.wcDate = wcDate;
		this.WUName = WUName;
		this.WWId = WWId;
	}

	/** full constructor */
	public Comments(String WUId, String wcContent, Double wcPoints,
			Timestamp wcDate, String WUName, String WWId, String WHwId) {
		this.WUId = WUId;
		this.wcContent = wcContent;
		this.wcPoints = wcPoints;
		this.wcDate = wcDate;
		this.WUName = WUName;
		this.WWId = WWId;
		this.WHwId = WHwId;
	}

	// Property accessors

	public Integer getWcId() {
		return this.wcId;
	}

	public void setWcId(Integer wcId) {
		this.wcId = wcId;
	}

	public String getWUId() {
		return this.WUId;
	}

	public void setWUId(String WUId) {
		this.WUId = WUId;
	}

	public String getWcContent() {
		return this.wcContent;
	}

	public void setWcContent(String wcContent) {
		this.wcContent = wcContent;
	}

	public Double getWcPoints() {
		return this.wcPoints;
	}

	public void setWcPoints(Double wcPoints) {
		this.wcPoints = wcPoints;
	}

	public Timestamp getWcDate() {
		return this.wcDate;
	}

	public void setWcDate(Timestamp wcDate) {
		this.wcDate = wcDate;
	}

	public String getWUName() {
		return this.WUName;
	}

	public void setWUName(String WUName) {
		this.WUName = WUName;
	}

	public String getWWId() {
		return this.WWId;
	}

	public void setWWId(String WWId) {
		this.WWId = WWId;
	}

	public String getWHwId() {
		return this.WHwId;
	}

	public void setWHwId(String WHwId) {
		this.WHwId = WHwId;
	}

}