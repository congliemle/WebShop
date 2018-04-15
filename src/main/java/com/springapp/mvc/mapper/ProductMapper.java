package com.springapp.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.springapp.mvc.model.Product;

public interface ProductMapper {

	@Insert("insert into product(productName, price, quantity, visible) "
			+ "values(#{productName}, #{price}, #{quantity}, #{visible})")
	public void add(Product product);

	@Update("update product set price=#{price}, "
			+ "quantity=#{quantity}, visible=#{visible} where productName=#{productName}")
	public void update(Product product);

	@Select("select * from product where productName=#{productName}")
	public Product findByProductName(String productName);

	@Select("select * from product")
	public List<Product> findAll();

	@Delete("delete from product where productName=#{productName}")
	public void delete(String productName);

}