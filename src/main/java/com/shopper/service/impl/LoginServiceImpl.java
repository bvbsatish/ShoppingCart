package com.shopper.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopper.dao.LoginDAO;
import com.shopper.model.Customer;
import com.shopper.model.Login;
import com.shopper.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;

	 @Transactional
	public void registerUser(Customer customer) {
		// TODO Auto-generated method stub
		 loginDAO.registerUser(customer);
	}

	public Customer validateUsers(Login login) {
		// TODO Auto-generated method stub
		 return loginDAO.validateUsers(login);
	}

	

	
}
