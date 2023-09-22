package com.ventech.batch.main.model;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
	
//	
//	@Id
//    private String productId;
//    private double price;
//    private int minimumOrderQuantity;
//    private String name;
//    private String description;
//    private SimpleDateFormat createTs;
//    private String category;
//    private int version;
//    private SimpleDateFormat updateTs;
	
	     @Id
	    long productId;
	    String productName ;
	    String description;
	    Date lastUpdatedDate;
	    Time lastUpdatedTime;
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "productId_fk")
	    Price price;
		
   
    //private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    //  System.out.println(sdf2.format(timestamp));  

}
