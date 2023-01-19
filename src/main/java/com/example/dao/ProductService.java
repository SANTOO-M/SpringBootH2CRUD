package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Product;

@Service
public class ProductService {

	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		System.out.println("Product Service Created");
		this.productRepository=productRepository;
	}
	
	public void saveProduct(Product p) {
		productRepository.save(p);
	}
	
	public List<Product> viewProducts(){
		List<Product> allProducts=(List<Product>) productRepository.findAll();
		return allProducts;
	}
	
	public Product findProduct(int pid) {
		Product find_product=productRepository.findById(pid).get();
		return find_product;		
	}
	
	public void productUpdate(Product p) {
		System.out.println(p.getPid()+"\t"+p.getPname()+"\t"+p.getQuantity()+"\t"+p.getPrice());
		Product p2=productRepository.findById(p.getPid()).get();
		p2.setPname(p.getPname());
		p2.setQuantity(p.getQuantity());
		p2.setPrice(p.getPrice());
		productRepository.save(p2);
	}
	
	public void productDelete(int pid) {
		productRepository.deleteById(pid);
	}
	
	public List<Product> findProductByName(String name){
		List<Product> productNames=productRepository.findBypname(name);
		return productNames;
	}
	
	public List<Product> findProductByQuantity(int quantity){
		List<Product> productquantity=productRepository.findByquantity(quantity);
		return productquantity;
	}
	
	public List<Product> findProductByQuantityGreaterThan(int quantity){
		List<Product> productquantity=productRepository.findByquantityGreaterThan(quantity);
		return productquantity;
	}
}





