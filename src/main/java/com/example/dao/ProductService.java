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
}
