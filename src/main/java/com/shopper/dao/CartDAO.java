package com.shopper.dao;

import java.util.List;

import com.shopper.model.Product;

public interface CartDAO {
	
	void addProductToCart(Long productId, Long customerId,Integer quantity);

	List<Product> fetchCartDetails(Long customerId);

}
