package com.shopper.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CartDetails")
public class CartDetails  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5375527333398609651L;
	@Id
	@GenericGenerator(name="CartDetails" , strategy="increment")
	@GeneratedValue(generator="CartDetails")
	@Column(name = "Details_Id")
	private int detailsId;
	@Column(name = "Customer_Id")
	private Long customerId;
	@Column(name = "Quantity")
	private int quantity;
	/*@Column(name = "Product_Id")
	private Long productId;*/
	
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="ProductId")    
	private Product product;
	
	
	

	

	
	
	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public CartDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CartDetails(int detailsId, Long customerId, int quantity) {
		super();
		this.detailsId = detailsId;
		this.customerId = customerId;
		this.quantity = quantity;
		/*this.productId = productId;*/
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getDetailsId() {
		return detailsId;
	}
	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/*	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}*/

	
	
	
	
	

}
