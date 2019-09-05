package com.shopper.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopper.model.Product;
import com.shopper.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"/productdetail"})
	   public String userForm(Locale locale,
			   @RequestParam("productId") Long productId
			   ,Model model) {
    System.out.println("productId in controller:"+productId);
    
    Product product=productService.fetchDetails(productId); 
		System.out.println("chwkecing in nconreoleer");
		model.addAttribute("product",product);

	      return "productdetail";
	   }
}
