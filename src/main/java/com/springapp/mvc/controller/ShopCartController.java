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
import com.springapp.mvc.model.ShopCart;
import com.springapp.mvc.service.IProductService;
import com.springapp.mvc.service.IShopCartService;

@RestController
@RequestMapping("/carts")
public class ShopCartController {

	@Autowired
	@Qualifier("shopCartService")
	private IShopCartService shopCartService;

	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
	public String listProducts(ModelMap model) {
		model.addAttribute("products", shopCartService.getAllProduct());
		return "getProducts";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String listCarts(ModelMap model) {
		model.addAttribute("carts", shopCartService.getAllCart());
		return "getCarts";
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.GET, produces = "application/json")
	public String getCart(@PathVariable("cartId") String cartId, ModelMap model) {
		model.addAttribute("cart", shopCartService.getByCardId(cartId));
		return "getCart";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createCart(@RequestParam("cartId") String cartId, @RequestParam("productName") String productName,
			@RequestParam("quantity") int quantity, ModelMap model) throws Exception {
		Product product = productService.getProduct(productName);
		if (product == null) {
			throw new Exception("Product with name " + productName + " does not exist!");
		}
		if (product.getVisible() == 0) {
			throw new Exception("Product with name " + productName + " is not visible at the moment!");
		}
		ShopCart cart = new ShopCart(cartId, productName, quantity,
				productService.getProduct(productName).getPrice().multiply(new BigDecimal(quantity)));
		shopCartService.addCart(cart);
		product.setQuantity(product.getQuantity() - quantity);
		productService.updateProduct(product);
		model.addAttribute("cart", cart);
		return "getCart";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCart(@RequestParam("cartId") String cartId, @RequestParam("productName") String productName,
			@RequestParam("quantity") int quantity, ModelMap model) throws Exception {
		ShopCart cart = shopCartService.getByCardId(cartId);
		if (cart == null) {
			throw new Exception("Cart " + cartId + " does not exist!");
		}
		Product product = productService.getProduct(cart.getProductName());
		int quantityFromCart = cart.getQuantity();
		product.setQuantity(product.getQuantity() + quantityFromCart);
		productService.updateProduct(product);
		product = productService.getProduct(productName);
		if (product == null) {
			throw new Exception("Product with name " + productName + " does not exist!");
		}
		if (product.getVisible() == 0) {
			throw new Exception("Product with name " + productName + " is not visible at the moment!");
		}
		cart = new ShopCart(cartId, productName, quantity,
				productService.getProduct(productName).getPrice().multiply(new BigDecimal(quantity)));
		shopCartService.updateCart(cart);
		product.setQuantity(product.getQuantity() - quantity);
		productService.updateProduct(product);
		model.addAttribute("cart", cart);
		return "getCart";
	}

	@RequestMapping(value = "/delete/{cartId}", method = RequestMethod.POST)
	public String deleteCart(@PathVariable("cartId") String cartId, ModelMap model) throws Exception {
		ShopCart cart = shopCartService.getByCardId(cartId);
		if (cart == null) {
			throw new Exception("Cart " + cartId + " does not exist!");
		}
		Product product = productService.getProduct(cart.getProductName());
		int quantityFromCart = cart.getQuantity();
		product.setQuantity(product.getQuantity() + quantityFromCart);
		productService.updateProduct(product);
		shopCartService.deleteCart(cartId);
		model.addAttribute("carts", shopCartService.getAllCart());
		return "getCarts";
	}
}
