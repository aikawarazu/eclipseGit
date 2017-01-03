package com.fh.domain;
// Generated Mar 27, 2016 10:33:23 AM by Hibernate Tools 4.3.1.Final

/**
 * Commodity generated by hbm2java
 */
public class Commodity implements java.io.Serializable {

	private Integer id;
	private String name;
	private Double price;
	private String unit;
	private String category;
	private String description;
	private Integer seller;

	public Commodity() {
	}

	public Commodity(String name, Double price, String unit, String category, String description, Integer seller) {
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.category = category;
		this.description = description;
		this.seller = seller;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSeller() {
		return this.seller;
	}

	public void setSeller(Integer seller) {
		this.seller = seller;
	}

}
