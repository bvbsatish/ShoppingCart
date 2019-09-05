package com.shopper.dao.impl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopper.dao.LoginDAO;
import com.shopper.model.Customer;
import com.shopper.model.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void registerUser(Customer customer) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().save(customer);
		
	}


	public Customer validateUsers(Login login) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		String hql="from Customer c where c.userName=:userName and c.password=:password";
		Query query = session.createQuery(hql);
        query.setParameter("userName", login.getUserName());
        query.setParameter("password", login.getPassword());
        Customer customer = (Customer) query.uniqueResult();

		return customer;
	}

	
	
}
