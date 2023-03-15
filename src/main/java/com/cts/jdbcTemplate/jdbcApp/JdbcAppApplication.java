package com.cts.jdbcTemplate.jdbcApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.jdbcTemplate.jdbcApp.service.ProductCreater;


@SpringBootApplication
public class JdbcAppApplication {
	
	private static final Logger log = LoggerFactory.getLogger(JdbcAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JdbcAppApplication.class, args);
		AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext();
		an.scan("com");
		an.refresh();
		ProductCreater pc =  an.getBean(ProductCreater.class);
		
		log.info("Starting ************ JdbcAppApplication");
		pc.processRequest();
		log.info("Ending ************ JdbcAppApplication");
	}
	

}
