package com.cts.jdbcTemplate.jdbcApp.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.jdbcTemplate.jdbcApp.model.Product;

@Repository
public class ProductrepositoryImpl implements Productrepository {

	private static final Logger log = LoggerFactory.getLogger(ProductrepositoryImpl.class);

	@Autowired
	private JdbcTemplate jt;

	public int count() {
		log.info("In side Count menthod");
		return jt.queryForObject("select count(*) from products", Integer.class);
	}

	@Override
	public List<Product> findAll() {
		return jt.query("select * from products", (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"),
				rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity")));
	}

	@Override
	public Optional<Product> findById(int id) {
		return jt.queryForObject("select * from products where id = ?", new Object[] { id },
				(rs, rowNum) -> Optional.of(new Product(rs.getInt("id"), rs.getString("name"),
						rs.getString("description"), rs.getDouble("price"), rs.getInt("quantity"))));
	}

	@Override
	public int save(Product product) {
		return jt.update("insert into products (id, name, description, price, quantity) values(?,?,?,?,?)",
				product.getId(), product.getName(), product.getDescription(), product.getPrice(),
				product.getQuantity());
	}

	@Override
	public int update(Product p) {
		return jt.update("update products set price = ? where id = ?", p.getPrice(), p.getId());
	}

	public int deleteById(int id) {
		return jt.update("delete products where id = ?", id);
	}

}
