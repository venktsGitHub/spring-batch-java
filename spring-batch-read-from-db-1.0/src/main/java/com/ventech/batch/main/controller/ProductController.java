package com.ventech.batch.main.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ventech.batch.main.model.Product;
import com.ventech.batch.main.repository.ProductRepo;

@RequestMapping("api/products")
@RestController
public class ProductController {

	@Autowired
	private ProductRepo pRepo;
	
	@GetMapping
	public List<Product> getProducts(){
		return pRepo.findAll();
	}
	
	
	@PostMapping
	public Product postProduct(@RequestBody Product product) {
		
		product.setLastUpdatedDate(new Date(System.currentTimeMillis()));
		product.setLastUpdatedTime(new Time(System.currentTimeMillis()));
		
		return pRepo.save(product);
	}
}
