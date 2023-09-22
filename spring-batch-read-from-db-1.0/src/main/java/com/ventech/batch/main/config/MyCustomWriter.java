package com.ventech.batch.main.config;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.ventech.batch.main.model.Product;

@Component
public class MyCustomWriter implements ItemWriter<Product> {

	@Override
	public void write(List<? extends Product> chunk) throws Exception {
		// TODO Auto-generated method stub
		for (Product data : chunk) {
			
			System.out.println("MyCustomWriter    : Writing data    : " 
					
			+ data.getProductId()+" : "+data.getProductName()
			+" : "+data.getDescription()+" : "+data.getLastUpdatedDate()+" : "
			+data.getLastUpdatedTime()+" : "+data.getPrice().getMrp()+" : "+data.getPrice().getDiscount()+" : "+data.getPrice().getPrice_id()
			
				);
			
		}
	}


	
}