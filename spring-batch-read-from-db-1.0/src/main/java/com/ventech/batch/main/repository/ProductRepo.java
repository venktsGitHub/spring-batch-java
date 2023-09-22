package com.ventech.batch.main.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ventech.batch.main.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}