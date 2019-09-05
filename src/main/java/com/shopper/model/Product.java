package com.shopper.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="products")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2339330768097426888L;
	@Id
	@GenericGenerator(name="Products", strategy="increment")
	@GeneratedValue(generator="Products")
	
	@Column(name="product_Id")
	private Long productId;
	@Column(name="brand")
	private String brand;
	@Column(name="product_code")
	private String productCode;
	@Column(name="reward_points")
	private double rewardPoints;
	@Column(name="available")
	private int Availability;
	@Column(name="price")
	private double price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="description")
	private String description;	
	@Column(name="size")
	private String size;
	@Column(name="color")
	private String color;
	
	@OneToOne(mappedBy="product", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private CartDetails cartDetails; 
	
	
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long productId, String brand, String productCode, double rewardPoints, int availability,
			double price, int quantity, String description, String size, String color) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.productCode = productCode;
		this.rewardPoints = rewardPoints;
		Availability = availability;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.size = size;
		this.color = color;
	}
	public CartDetails getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(CartDetails cartDetails) {
		this.cartDetails = cartDetails;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public double getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(double rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public int getAvailability() {
		return Availability;
	}
	public void setAvailability(int availability) {
		Availability = availability;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", brand=" + brand + ", productCode=" + productCode
				+ ", rewardPoints=" + rewardPoints + ", Availability=" + Availability + ", price=" + price
				+ ", quantity=" + quantity + ", description=" + description + ", size=" + size + ", color=" + color
				+ ", cartDetails=" + cartDetails + "]";
	}

	
	
}
