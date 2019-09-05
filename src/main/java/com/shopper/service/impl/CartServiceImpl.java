package com.shopper.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopper.dao.CartDAO;
import com.shopper.dao.LoginDAO;
import com.shopper.model.Product;
import com.shopper.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDAO cartDAO;
	
	@Transactional(rollbackOn=Exception.class)
	public void addProductToCart(Long productId, Long customerId,Integer quantity) {
		// TODO Auto-generated method stub
		
		cartDAO.addProductToCart(productId, customerId,quantity);
	}
	@Transactional
	public List<Product> fetchCartDetails(Long customerId) {
		// TODO Auto-generated method stub
		return cartDAO.fetchCartDetails(customerId);
	}
	
	
	

}
