package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.dao.ProductRepository;
import com.example.model.Product;

@RestController
public class HomeController {

	private ProductRepository productRepository;	
	public HomeController(ProductRepository productRepository) {
		this.productRepository=productRepository;
		System.out.println("Front-Control Object Created.");
	}
	
	@RequestMapping("/")
	public ModelAndView addProduct() {
		return new ModelAndView("Registration").addObject("product", new Product());
	}
	
	@PostMapping(path="/saveProduct",consumes= {"application/json"})
	public String saveProduct(@RequestBody Product p) {
		productRepository.save(p);
		return "Registration";
	}
	
	@PutMapping(path="/updateProduct",consumes= {"application/json"})
	public Product updateProduct(@RequestBody Product p) {
		productRepository.save(p);
		System.out.println("Updated");
		return p;
	}
	
	@DeleteMapping(path="/deleteProduct/{pid}",consumes= {"application/json"})
	public String updateProduct(@PathVariable("pid") int pid) {
		productRepository.deleteById(pid);
		System.out.println("Deleted");
		return "Deleted";
	}
	
	@GetMapping(path="/ViewAllProducts",produces = {"application/json"})
	@ResponseBody
	public Iterable<Product> allProducts() {		//ModelAndView
	
			return productRepository.findAll();
		/*
		 * List<Product> products=(List<Product>) productRepository.findAll(); return
		 * new ModelAndView("ViewAllProducts").addObject("products",products);
		 */
	}
	
	@GetMapping("/product/{productid}")
	@ResponseBody
	public Product viewOneProduct(@PathVariable("productid") int pid) {		//ModelAndView
			return productRepository.findById(pid).orElse(null);
	}
	
	@RequestMapping("/editProduct/{productid}")
	public String editProduct(@PathVariable("productid") int pid,Model m) {
		m.addAttribute("product", productRepository.findById(pid));
		return "ProductEdit";
	}

	/*
	 * @RequestMapping("/updateProduct") public String
	 * updateProduct(@ModelAttribute("product") Product product) {
	 * System.out.println("Here Controller");
	 * productRepository.productUpdate(product); return "ProductEdit"; }
	 * 
	 * @RequestMapping("/deleteProduct/{productid}") public String
	 * deleteProduct(@PathVariable("productid") int pid,Model m) {
	 * productRepository.productDelete(pid); List<Product>
	 * products=productRepository.viewProducts(); return
	 * "redirect:/ViewAllProducts"; }
	 * 
	 * @RequestMapping("/names/{n}") public String
	 * printNames(@PathVariable("n")String name, Model m) {
	 * System.out.println("Here Controller..."); List<Product>
	 * productnames=productRepository.findProductByName(name); for(int
	 * i=0;i<productnames.size();i++) {
	 * System.out.println(productnames.get(i).getPid()+"\t"+
	 * productnames.get(i).getPname()+"\t"+ productnames.get(i).getQuantity()+"\t"+
	 * productnames.get(i).getPrice()); } m.addAttribute("records",productnames);
	 * return "display"; }
	 * 
	 * @RequestMapping("/qty/{quantity}") public String
	 * printQuantity(@PathVariable("quantity") int quantity, Model m) {
	 * System.out.println("Quantity..."); List<Product>
	 * productnames=productRepository.findProductByQuantity(quantity); for(int
	 * i=0;i<productnames.size();i++) {
	 * System.out.println(productnames.get(i).getPid()+"\t"+
	 * productnames.get(i).getPname()+"\t"+ productnames.get(i).getQuantity()+"\t"+
	 * productnames.get(i).getPrice()); } m.addAttribute("records",productnames);
	 * return "display"; }
	 * 
	 * @RequestMapping("/gt/{quantity}") public String
	 * printQuantityGT(@PathVariable("quantity") int quantity, Model m) {
	 * System.out.println("Quantity..."); List<Product>
	 * productnames=productRepository.findProductByQuantityGreaterThan(quantity);
	 * for(int i=0;i<productnames.size();i++) {
	 * System.out.println(productnames.get(i).getPid()+"\t"+
	 * productnames.get(i).getPname()+"\t"+ productnames.get(i).getQuantity()+"\t"+
	 * productnames.get(i).getPrice()); } m.addAttribute("records",productnames);
	 * return "display"; }
	 */
	
}
