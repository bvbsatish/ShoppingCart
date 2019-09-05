package com.shopper.dao;

import com.shopper.model.Product;

public interface ProductDAO {

	
	Product fetchDetails(Long productId);
}
