package com.ventech.batch.main.config;


import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.ventech.batch.main.model.Product;



@Component
public class MyCustomProcessor implements ItemProcessor<Product, Product> {

	@Override
	public Product process(Product product) throws Exception {
		
File path = new File("src/main/resources/data.txt");
//		String lastUpdatedProductDetails = new String(Files.readAllBytes(path.toPath()));
//		
//		   DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//	       Date d = dateFormat.parse(lastUpdatedProductDetails.substring(0,8));
	       
	    //System.out.println("Resultant Date and Time = " + d.getTime());
		
		//System.out.println(product.getProductName());
		
//		if(product.getLastUpdatedTime().getTime()>=d.getTime() &&
//				product.getProductId() != Integer.valueOf(lastUpdatedProductDetails.substring(9)) )
//		{
//			FileWriter wr = new FileWriter(path);
//			
//	        wr.write(product.getLastUpdatedTime().toString()+" "+product.getProductId());
//	        wr.flush();
//	        wr.close();
//	        
//			return product;
//		}
		
	       if(product!=null) {
				FileWriter wr = new FileWriter(path);
				
		        //wr.write(product.getLastUpdatedTime().toString()+" "+product.getProductId());
		        wr.write(product.getLastUpdatedTime().toString());
		        wr.flush();
		        wr.close();
	       }
	       
		return product;	
	}
}