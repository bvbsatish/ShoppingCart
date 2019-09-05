package com.shopper.dao.impl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopper.dao.ProductDAO;
import com.shopper.model.Customer;
import com.shopper.model.Product;
@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Product fetchDetails(Long productId) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.openSession();
		String hql="from Product p where p.productId=:productId";
		Query query = session.createQuery(hql);
        query.setParameter("productId", productId);
        Product product = (Product) query.uniqueResult();

		return product;
	}
	
	

}
