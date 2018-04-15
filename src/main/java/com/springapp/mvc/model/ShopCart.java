package com.springapp.mvc.model;

import java.math.BigDecimal;

public class ShopCart {

	private String cartId;
	private String productName;
	private int quantity;
	private BigDecimal grandTotal;

	public ShopCart() {

	}

	public ShopCart(String cartId, String productName, int quantity, BigDecimal grandTotal) {
		super();
		this.cartId = cartId;
		this.productName = productName;
		this.quantity = quantity;
		this.grandTotal = grandTotal;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public BigDecimal getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(BigDecimal grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Override
	public String toString() {
		return "ShopCart [cartId=" + cartId + ", productName=" + productName + ", quantity=" + quantity
				+ ", grandTotal=" + grandTotal + "]";
	}
}
