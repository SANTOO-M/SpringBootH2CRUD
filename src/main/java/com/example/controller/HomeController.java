package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.ProductService;
import com.example.model.Product;

@Controller
public class HomeController {

	private ProductService productService;
	
	public HomeController(ProductService productService) {
		this.productService=productService;
		System.out.println("Front-Control Object Created.");
	}
	
	@RequestMapping("/")
	public String addProduct() {
		return "Registration";
	}
	
	@RequestMapping("/saveProduct")
	public String saveProduct(Product p) {
		productService.saveProduct(p);
		return "Registration";
	}
	
	@RequestMapping("/ViewAllProducts")
	public ModelAndView allProducts() {
		List<Product> products=productService.viewProducts();
		return new ModelAndView("ViewAllProducts").addObject("products",products);
	}

}
