package com.shopper.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopper.dao.CartDAO;
import com.shopper.model.CartDetails;
import com.shopper.model.Product;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addProductToCart(Long productId, Long customerId,Integer quantity) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		Product product=null;
		Query query=null;
		CartDetails cartDetails  =null;
		try {
			query =session.createQuery("from Product where productId=:productId");
			query.setParameter("productId",productId);
			product=(Product) query.getSingleResult();
			
			cartDetails= product.getCartDetails();
					
			/*CartDetails cartDetails  = (CartDetails) session.createQuery("from CartDetails c where c.productId=:productId and c.customerId=:customerId").setParameter("productId", productId).setParameter("customerId", customerId).uniqueResult();*/
			
			
			/*Transaction tx = session.beginTransaction();*/
			
			if(cartDetails!=null){
				
				int detailsId=cartDetails.getDetailsId();
				System.out.println("data exists"+cartDetails.getQuantity()+"detailsId"+detailsId);
				cartDetails.setQuantity(quantity);
				cartDetails.setDetailsId(detailsId);
				cartDetails.setProduct(product);
				session.saveOrUpdate(cartDetails);
				
			}else{
				System.out.println("NO data");
				CartDetails cartDetails1=new CartDetails();
				cartDetails1.setCustomerId(customerId);
				/*cartDetails1.setProductId(productId);*/
				cartDetails1.setProduct(product);
				cartDetails1.setQuantity(quantity);
				
				session.save(cartDetails1);
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*tx.commit();*/
		
	}

	public List<Product> fetchCartDetails(Long customerId) {
		// TODO Auto-generated method stub
		System.out.println("fetchCartDetails method: "+customerId);
		Session session = sessionFactory.getCurrentSession();
		List<Product> productsList =null;	
		List<CartDetails> cartDetailsList = null;
		Query query=null;
		try {
			query=session.createQuery("from CartDetails where customerId=:customerId",CartDetails.class);
			query.setParameter("customerId", customerId);
			cartDetailsList=query.getResultList();
			productsList=new ArrayList<Product>();
			for (CartDetails cartDetails : cartDetailsList) {
				productsList.add(cartDetails.getProduct());
			}
			
/*List<Product> productsList =  session.createQuery("from Product where productId IN(SELECT productId from CartDetails WHERE customerId=:customerId)").setParameter("customerId", customerId).list();*/
			
			
for(Product s: productsList){
   System.out.println("Details : "+s);
}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		System.out.println("chekcing fetch productss productsList size"+productsList.size());
		return productsList;
	}	
}
