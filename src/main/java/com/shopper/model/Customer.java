package com.shopper.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="Customer",schema="shopper")

public class Customer implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = -6563232031968685582L;
@Id
@GenericGenerator(name="Customer", strategy="increment")
@GeneratedValue(generator="Customer")
@Column(name="Customer_Id")
private Long customerId;
@Column(name="User_Name")
@Size(max = 20, min = 3, message = "{customer.name.invalid}")
private String userName;
@Column(name="Email_Address")
@Email(message = "{customer.email.invalid}")
private String emailAddress;
@Column(name="Password")
private String password;



public String getEmailAddress() {
	return emailAddress;
}
public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
