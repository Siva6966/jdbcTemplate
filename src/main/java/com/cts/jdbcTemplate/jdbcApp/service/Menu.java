package com.cts.jdbcTemplate.jdbcApp.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.jdbcTemplate.jdbcApp.dao.Productrepository;
import com.cts.jdbcTemplate.jdbcApp.model.Product;

@Component
public class Menu {

	private static final Logger log = LoggerFactory.getLogger(Menu.class);

	@Autowired
	private Productrepository impl;
	private Scanner scanner;

	public Menu() {
		scanner = new Scanner(System.in);
	}

	public void displayMenu() {
		System.out.println("1. Display all products");
		System.out.println("2. Display a single product by id");
		System.out.println("3. Add a new product");
		System.out.println("4. Update an existing product");
		System.out.println("5. Delete a product");
		System.out.println("6. Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			displayAllProducts();
			break;
		case 2:
			displayProductById();
			break;
		case 3:
			addProduct();
			break;
		case 4:
			updateProduct();
			break;
		case 5:
			deleteProduct();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
		displayMenu();
	}

	private void displayAllProducts() {
		List<Product> prod = impl.findAll();
		prod.stream().forEach(r -> {
			System.out.println(r.toString());
		});
	}

	private void displayProductById() {
		Optional<Product> product = impl.findById(4);
		Product product2 = product.get();
		System.out.println(product2.toString());
	}

	private void addProduct() {
		Product p = new Product();
		p.setId(11);
		p.setName("Oneplus");
		p.setDescription("Mobile");
		p.setPrice(45000);
		p.setQuantity(10);
		int save = impl.save(p);
		if (save == 1)
			log.info("Product saved **********");
	}

	private void updateProduct() {
		Product p = new Product();
		p.setId(11);
		p.setPrice(50000);
		int status = impl.update(p);
		if (status == 1)
			log.info("Product Updated ********");
	}

	private void deleteProduct() {
		int deleteById = impl.deleteById(11);
		if (deleteById == 1)
			log.info("Product Deeleted **********");
	}
}
