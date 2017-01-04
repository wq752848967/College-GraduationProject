package com.icephone.pojo;

import java.sql.Timestamp;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */

public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orderId;
	private String UCusId;
	private String UWorkId;
	private Integer orderStatusCode;
	private Timestamp orderDate;
	private String UHworkId;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(String orderId, String UCusId, String UWorkId,
			Integer orderStatusCode, Timestamp orderDate, String UHworkId) {
		this.orderId = orderId;
		this.UCusId = UCusId;
		this.UWorkId = UWorkId;
		this.orderStatusCode = orderStatusCode;
		this.orderDate = orderDate;
		this.UHworkId = UHworkId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUCusId() {
		return this.UCusId;
	}

	public void setUCusId(String UCusId) {
		this.UCusId = UCusId;
	}

	public String getUWorkId() {
		return this.UWorkId;
	}

	public void setUWorkId(String UWorkId) {
		this.UWorkId = UWorkId;
	}

	public Integer getOrderStatusCode() {
		return this.orderStatusCode;
	}

	public void setOrderStatusCode(Integer orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getUHworkId() {
		return this.UHworkId;
	}

	public void setUHworkId(String UHworkId) {
		this.UHworkId = UHworkId;
	}

}