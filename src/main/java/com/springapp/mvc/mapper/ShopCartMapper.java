package com.springapp.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springapp.mvc.model.Product;
import com.springapp.mvc.model.ShopCart;

public interface ShopCartMapper {

	@Select("select * from product where visible = 1")
	public List<Product> findAll();

	@Select("select * from cart")
	public List<ShopCart> getAllCart();

	@Insert("insert into cart(cartId, productName, quantity, grandTotal) "
			+ "values(#{cartId}, #{productName}, #{quantity}, #{grandTotal})")
	public void addCart(ShopCart cart);

	@Select("select * from cart where cartId=#{cartId}")
	public ShopCart getByCardId(String cartId);

	@Delete("delete from cart where cartId=#{cartId}")
	public void deleteCart(String cartId);

	@Update("update cart set productName=#{productName}, "
			+ "quantity=#{quantity}, grandTotal=#{grandTotal} where cartId=#{cartId}")
	public void updateCart(ShopCart cart);

}
