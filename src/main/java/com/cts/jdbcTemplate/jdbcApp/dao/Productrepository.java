package com.cts.jdbcTemplate.jdbcApp.dao;

import java.util.List;
import java.util.Optional;

import com.cts.jdbcTemplate.jdbcApp.model.Product;

public interface Productrepository {

	int count();

	List<Product> findAll();

	Optional<Product> findById(int id);

	int save(Product product);

	int update(Product product);

	int deleteById(int id);

}
