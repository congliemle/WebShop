package com.springapp.mvc.model;

import java.math.BigDecimal;

public class Product {

	private String productName;
	private BigDecimal price;
	private int quantity;
	private int visible;

	public Product() {

	}

	public Product(String productName, BigDecimal price, int quantity, int visible) {
		super();
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.visible = visible;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", price=" + price + ", quantity=" + quantity + ", visible="
				+ visible + "]";
	}
}