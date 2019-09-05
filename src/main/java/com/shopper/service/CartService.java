package com.shopper.service;

import java.util.List;

import com.shopper.model.Product;

public interface CartService {

	void addProductToCart(Long productId, Long customerId,Integer quantity);

	List<Product> fetchCartDetails(Long customerId);
	
	

}
