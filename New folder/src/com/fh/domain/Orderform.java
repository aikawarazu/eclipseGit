package com.fh.domain;
// Generated Mar 27, 2016 10:33:23 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * Orderform generated by hbm2java
 */
public class Orderform implements java.io.Serializable {

	private Integer id;
	private Integer customer;
	private Date tradedate;
	private String status;
	private Double amount;

	public Orderform() {
	}

	public Orderform(Integer customer, Date tradedate, String status, Double amount) {
		this.customer = customer;
		this.tradedate = tradedate;
		this.status = status;
		this.amount = amount;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Integer customer) {
		this.customer = customer;
	}

	public Date getTradedate() {
		return this.tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
