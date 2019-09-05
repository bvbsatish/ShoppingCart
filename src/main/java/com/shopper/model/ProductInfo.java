package com.shopper.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="product")
public class ProductInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name="product" , strategy="increment")
	@GeneratedValue(generator="product")
	@Column(name = "Product_Id")
	private Long productId;
	
	@Column(name = "Name")
	private String name;	
	@Column(name = "Price")
	private Double price;
	@Column(name = "Available")
	private Integer available;
	@Column(name = "Description")
	private String description;
	@Column(name = "Manufacturer")
	private String manufacturer;
	@Column(name = "quantity")
	private Long Qty;
	@Column(name = "brand")
	private String Brand ;
	@Column(name = "product_code")
	private String ProductCode ;
	
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Long getQty() {
		return Qty;
	}
	public void setQty(Long qty) {
		Qty = qty;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getProdctCode() {
		return ProductCode;
	}
	public void setProdctCode(String prodctCode) {
		ProductCode = prodctCode;
	}
	

}
