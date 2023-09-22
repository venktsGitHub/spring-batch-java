package com.ventech.spring.batch.main.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class CustomConfiguration {

@Scheduled(fixedDelay = 1000*5)
 public void printHello() {
	 System.out.println("Hello "+System.currentTimeMillis());
 }

}
