package com.shopper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shopper.model.Customer;
import com.shopper.model.Product;
import com.shopper.service.CartService;
import com.shopper.service.ProductService;

@Controller
public class CartController {

	
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addProducttoCart")
	public ModelAndView addProductToCart(@RequestParam("productId") Long productId,
			@RequestParam("quantity") Integer quantity,
			HttpServletRequest request){
		System.out.println("quantity in addProductToCart:"+quantity+"productId:"+productId);
		Customer customer=(Customer) request.getSession().getAttribute("customer");
		if (customer!=null)
		cartService.addProductToCart(productId,customer.getCustomerId(),quantity);
		
		//return new ModelAndView("redirect:/productdetail", "productId", productId);	
		return new ModelAndView("redirect:/cart");
		
	}
	
	@GetMapping("/cart")
	public String fetchCartDetails(
			HttpServletRequest request,Model model){
		Customer customer=(Customer) request.getSession().getAttribute("customer");
		List<Product> product=new ArrayList<Product>();
		if (customer!=null){		
		 product=cartService.fetchCartDetails(customer.getCustomerId());
		}
		
//		for (int i = 0; i < product.size(); i++) {
//			
//			System.out.println("product id:"+product.get(i).getProductId());
//			System.out.println("product name:"+product.get(i).getDescription());
//			System.out.println("product qunatity:"+product.get(i).getCartDetails().getQuantity());
//		}
		model.addAttribute("productsList",product);
		System.out.println("fetchCartDetails method");
		return "cart";
	}	
}
