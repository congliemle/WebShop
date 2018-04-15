package com.springapp.mvc.service;

import java.util.List;

import com.springapp.mvc.model.Product;

public interface IProductService {

	public List<Product> getAllProduct();

	public Product getProduct(String productName);

	public void addProduct(Product product);

	public void deleteProduct(String productName);

	public void updateProduct(Product product);

}
