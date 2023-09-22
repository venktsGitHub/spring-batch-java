package com.ventech.batch.main.config;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.ventech.batch.main.model.Price;
import com.ventech.batch.main.model.Product;



@Component
public class MyCustomReader extends JdbcCursorItemReader<Product> implements ItemReader<Product>{
	
	public MyCustomReader(@Autowired DataSource dataSource) throws IOException {
		
		
//		
//		File path = new File("src/main/resources/data.txt");	
//		String time = new String(Files.readAllBytes(path.toPath()));		
//		
		
		
		setDataSource(dataSource);
		//String sql="SELECT * FROM product";
		
		String sql ="SELECT * FROM pract.product p  JOIN  pract.price q  where q.price_id = p.product_id_fk; ";
		
		
//		
//		PreparedStatementSetter pSetter= new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, time);
//			}
//		};
		
		setSql(sql);
	//	setPreparedStatementSetter(pSetter);
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
			product.setLastUpdatedDate(rs.getDate("last_updated_date"));
			product.setLastUpdatedTime(rs.getTime("last_updated_time"));
			
			Price price = new Price();
			price.setMrp(rs.getDouble("mrp"));
			price.setDiscount(rs.getDouble("discount"));
			price.setPrice_id(rs.getLong("price_id"));
			
			product.setPrice(price);
			
			
			return product;
		}
	}
}