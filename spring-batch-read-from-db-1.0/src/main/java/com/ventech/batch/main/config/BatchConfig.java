package com.ventech.batch.main.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ventech.batch.main.model.Product;



@Configuration
@EnableBatchProcessing

public class BatchConfig {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
		
	@Autowired
	MyCustomReader myCustomReader;
	
	@Autowired
	MyCustomWriter myCustomWriter;

	@Autowired
	MyCustomProcessor myCustomProcessor;
	
	@Bean
	public Job createJob() {
		return jobBuilderFactory.get("MyJob")
				.incrementer(new RunIdIncrementer())
				.flow(createStep()).end().build();
	}
	
	

	@Bean
	public Step createStep() {
		return stepBuilderFactory.get("MyStep")
				.<Product, Product> chunk(1)
				.reader(myCustomReader)
				.processor(myCustomProcessor)
				.writer(myCustomWriter)
				.build();
	}
	
	
	
	
}
