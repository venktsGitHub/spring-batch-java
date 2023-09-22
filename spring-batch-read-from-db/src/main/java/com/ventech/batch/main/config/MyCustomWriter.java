package com.ventech.batch.main.config;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.ventech.batch.main.model.Product;

@Component
public class MyCustomWriter implements ItemWriter<Product> {

	@Override
	public void write(Chunk<? extends Product> chunk) throws Exception {
		// TODO Auto-generated method stub
		for (Product data : chunk) {
			
			System.out.println("MyCustomWriter    : Writing data    : " + data.getProductId()+" : "+data.getProductName()+" : "+data.getDescription());
			
		}
	}
	
	
//	@Override
//	public void write(List<? extends Product> list) throws Exception {
//		for (Product data : list) {
//			System.out.println("MyCustomWriter    : Writing data    : " + data.getProductId()+" : "+data.getProductName()+" : "+data.getDescription());
//			
//		}
//	}

	
}