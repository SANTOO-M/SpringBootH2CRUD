package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/editProduct/{productid}")
	public String editProduct(@PathVariable("productid") int pid,Model m) {
		m.addAttribute("product", productService.findProduct(pid));
		return "ProductEdit";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product) {
		System.out.println("Here Controller");
		productService.productUpdate(product);
		return "ProductEdit";
	}
	@RequestMapping("/deleteProduct/{productid}")
	public String deleteProduct(@PathVariable("productid") int pid,Model m) {
		productService.productDelete(pid);
		List<Product> products=productService.viewProducts();
		return "redirect:/ViewAllProducts";
	}
	
	@RequestMapping("/names/{n}")
	public String printNames(@PathVariable("n")String name, Model m) {
		System.out.println("Here Controller...");
		List<Product> productnames=productService.findProductByName(name);
		for(int i=0;i<productnames.size();i++) {
			System.out.println(productnames.get(i).getPid()+"\t"+
					productnames.get(i).getPname()+"\t"+
					productnames.get(i).getQuantity()+"\t"+
					productnames.get(i).getPrice());
		}
		m.addAttribute("records",productnames);
		return "display";
	}
	
	@RequestMapping("/qty/{quantity}")
	public String printQuantity(@PathVariable("quantity") int quantity, Model m) {
		System.out.println("Quantity...");
		List<Product> productnames=productService.findProductByQuantity(quantity);
		for(int i=0;i<productnames.size();i++) {
			System.out.println(productnames.get(i).getPid()+"\t"+
					productnames.get(i).getPname()+"\t"+
					productnames.get(i).getQuantity()+"\t"+
					productnames.get(i).getPrice());
		}
		m.addAttribute("records",productnames);
		return "display";
	}
	
	@RequestMapping("/gt/{quantity}")
	public String printQuantityGT(@PathVariable("quantity") int quantity, Model m) {
		System.out.println("Quantity...");
		List<Product> productnames=productService.findProductByQuantityGreaterThan(quantity);
		for(int i=0;i<productnames.size();i++) {
			System.out.println(productnames.get(i).getPid()+"\t"+
					productnames.get(i).getPname()+"\t"+
					productnames.get(i).getQuantity()+"\t"+
					productnames.get(i).getPrice());
		}
		m.addAttribute("records",productnames);
		return "display";
	}
}
