package com.example.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product , Integer>{
	List<Product> findBypname(String name);
	List<Product> findByquantity(int quantity);
	List<Product> findByquantityGreaterThan(int quantity);
}
 