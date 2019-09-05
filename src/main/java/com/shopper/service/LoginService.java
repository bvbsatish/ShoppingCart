package com.shopper.service;

import com.shopper.model.Customer;
import com.shopper.model.Login;

public interface LoginService {

	void registerUser(Customer customer);
	
	Customer validateUsers(Login login);
	
}
