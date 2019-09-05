package com.shopper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopper.dao.ProductDAO;
import com.shopper.model.Product;
import com.shopper.service.ProductService;
@Service
public class ProductServiceImpl  implements ProductService{

	@Autowired
	private ProductDAO productDAO;
	
	public Product fetchDetails(Long productId) {
		// TODO Auto-generated method stub
		
		return productDAO.fetchDetails(productId);
	}
	
	

}
