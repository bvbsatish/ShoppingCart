package com.shopper.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopper.model.Customer;
import com.shopper.model.Login;
import com.shopper.service.LoginService;

@Controller
public class LoginController {
	
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping({"/","/login"})
	   public String userForm(Locale locale, Model model) {

	      //model.addAttribute("user", new User());
	      //model.addAttribute("users", userService.list());
		

	      return "register";
	   }
	
	@PostMapping("/register")
	public String registerUser(
			
			@ModelAttribute("customerForm") @Valid Customer customer, 
			BindingResult result,Model model,
			RedirectAttributes redir, HttpServletRequest request) {
		
		
     loginService.registerUser(customer);
		
		return "register";

   }
	
	@PostMapping("/login")
	public String LoginValidation(
			
			@ModelAttribute("loginForm") @Valid Login login, 
			BindingResult result,Model model,
			RedirectAttributes redir, HttpServletRequest request) {
		
		
		Customer customer=validateCustomer(login);
		
		request.getSession().setAttribute("customer", customer);
		if (customer!=null) {
			return "index";
		}
		
		return "register";
   }
	
	private Customer validateCustomer(Login login) {		
		Customer customer = loginService.validateUsers(login);
		return customer;
	}
	

}