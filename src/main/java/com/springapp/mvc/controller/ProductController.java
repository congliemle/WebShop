package com.springapp.mvc.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springapp.mvc.model.Product;
import com.springapp.mvc.service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String listProducts(ModelMap model) {
		model.addAttribute("products", productService.getAllProduct());
		return "getProducts";
	}

	@RequestMapping(value = "/{productName}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String findByProductName(@PathVariable("productName") String productName, ModelMap model) throws Exception {
		if (productService.getProduct(productName) == null) {
			throw new Exception("Product with name " + productName + " does not exist!");
		}
		model.addAttribute("product", productService.getProduct(productName));
		return "getProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@RequestParam("productName") String productName, @RequestParam("price") BigDecimal price,
			@RequestParam("quantity") int quantity, @RequestParam("visible") int visible, ModelMap model) {
		Product product = new Product(productName, price, quantity, visible);
		productService.addProduct(product);
		model.addAttribute("products", productService.getAllProduct());
		return "getProducts";
	}

	@RequestMapping(value = "/delete/{productName}", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable("productName") String productName, ModelMap model) throws Exception {
		if (productService.getProduct(productName) == null) {
			throw new Exception("Product with name " + productName + " does not exist!");
		}
		productService.deleteProduct(productName);
		model.addAttribute("products", productService.getAllProduct());
		return "getProducts";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateProduct(@RequestParam("productName") String productName,
			@RequestParam("price") BigDecimal price, @RequestParam("quantity") int quantity,
			@RequestParam("visible") int visible, ModelMap model) throws Exception {
		if (productService.getProduct(productName) == null) {
			throw new Exception("Product with name " + productName + " does not exist!");
		}
		Product product = new Product(productName, price, quantity, visible);
		productService.updateProduct(product);
		model.addAttribute("products", productService.getAllProduct());
		return "getProducts";
	}

}
