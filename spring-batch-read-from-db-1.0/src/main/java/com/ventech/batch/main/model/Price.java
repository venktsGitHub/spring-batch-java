package com.ventech.batch.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long price_id;
	private double mrp;
	private double discount;
	

}
