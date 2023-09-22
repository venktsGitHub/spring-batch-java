package com.ventech.batch.main.config;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ventech.batch.main.model.Product;



@Component
public class MyCustomReader extends JdbcCursorItemReader<Product> implements ItemReader<Product>{
	
	public MyCustomReader(@Autowired DataSource dataSource) {
		setDataSource(dataSource);
		setSql("SELECT product_id,product_name,description FROM product");
		setFetchSize(10);
		setRowMapper(new ProductRowMapper());
	}
	
	 public class ProductRowMapper implements RowMapper<Product> {
		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product  = new Product();
			product.setProductId(rs.getLong("product_id"));
			product.setProductName(rs.getString("product_name"));
			product.setDescription(rs.getString("description"));
			return product;
		}
	}
}