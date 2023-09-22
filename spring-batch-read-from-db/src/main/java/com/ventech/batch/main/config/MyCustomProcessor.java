package com.ventech.batch.main.config;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ventech.batch.main.model.Product;


@Component
public class MyCustomProcessor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product product) throws Exception {
		
		return product;
	}
}