package com.ventech.batch.main.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
	
	
	@Id
	long productId;
	String productName ;
	String description;
	Date lastUpdatedDate;
	Time lastUpdatedTime;

}
