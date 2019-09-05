package com.shopper.dao;

import com.shopper.model.Customer;
import com.shopper.model.Login;

public interface LoginDAO {

	void registerUser(Customer customer);

	Customer validateUsers(Login login);	
}
