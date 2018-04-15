package com.springapp.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.mvc.mapper.ShopCartMapper;
import com.springapp.mvc.model.Product;
import com.springapp.mvc.model.ShopCart;
import com.springapp.mvc.service.IShopCartService;

@Service("shopCartService")
public class ShopCartService implements IShopCartService {

	@Autowired
	private ShopCartMapper mapper;

	@Override
	public List<Product> getAllProduct() {
		return mapper.findAll();
	}

	@Override
	public void addCart(ShopCart cart) {
		mapper.addCart(cart);
	}

	@Override
	public ShopCart getByCardId(String cartId) {
		return mapper.getByCardId(cartId);
	}

	@Override
	public void deleteCart(String cartId) {
		mapper.deleteCart(cartId);
	}

	@Override
	public void updateCart(ShopCart cart) {
		mapper.updateCart(cart);
	}

	@Override
	public List<ShopCart> getAllCart() {
		return mapper.getAllCart();
	}

}
