package com.cts.jdbcTemplate.jdbcApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.jdbcTemplate.jdbcApp.dao.Productrepository;
import com.cts.jdbcTemplate.jdbcApp.model.Product;

@Component
public class ProductCreater {

	private static final Logger log = LoggerFactory.getLogger(ProductCreater.class);

	@Autowired
	private Productrepository impl;

	public void processRequest() {
		log.info("Starting ************ processRequest");
		int count = impl.count();
		log.info("Count *************" + count);

		Optional<Product> product = impl.findById(4);
		Product product2 = product.get();
		System.out.println(product2.toString());
		log.info("After FindByID ************");

		Product p = new Product();
		p.setId(11);
		p.setName("Oneplus");
		p.setDescription("Mobile");
		p.setPrice(45000);
		p.setQuantity(10);
		int save = impl.save(p);
		if (save == 1)
			log.info("Product saved **********");

		p.setPrice(50000);
		int status = impl.update(p);
		if (status == 1)
			log.info("Product Updated ********");

		log.info("Before FindAll ************");
		List<Product> products = impl.findAll();
		products.stream().forEach(r -> {
			System.out.println(r.toString());
		});
		log.info("After FindAll ************");

		int deleteById = impl.deleteById(11);
		if (deleteById == 1)
			log.info("Product Deeleted **********");

		log.info("Before FindAll ************");
		List<Product> prod = impl.findAll();
		prod.stream().forEach(r -> {
			System.out.println(r.toString());
		});
		log.info("After FindAll ************");

	}

}
