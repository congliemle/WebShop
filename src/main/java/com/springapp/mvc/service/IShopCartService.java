package com.springapp.mvc.service;

import java.util.List;

import com.springapp.mvc.model.Product;
import com.springapp.mvc.model.ShopCart;

public interface IShopCartService {

	public List<Product> getAllProduct();

	public List<ShopCart> getAllCart();

	public void addCart(ShopCart cart);

	public ShopCart getByCardId(String cartId);

	public void deleteCart(String cartId);

	public void updateCart(ShopCart cart);

}
