package com.springapp.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapp.mvc.mapper.ProductMapper;
import com.springapp.mvc.model.Product;
import com.springapp.mvc.service.IProductService;

@Service("productService")
public class ProductService implements IProductService {
	@Autowired
	private ProductMapper mapper;

	@Override
	public List<Product> getAllProduct() {
		return mapper.findAll();
	}

	@Override
	public Product getProduct(String productName) {
		return mapper.findByProductName(productName);
	}

	@Override
	public void addProduct(Product product) {
		mapper.add(product);
	}

	@Override
	public void deleteProduct(String productName) {
		mapper.delete(productName);
	}

	@Override
	public void updateProduct(Product product) {
		mapper.update(product);
	}

}
