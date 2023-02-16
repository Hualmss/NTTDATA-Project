package com.nttdata.movimients.service;

import java.util.List;

import com.nttdata.movimients.model.Product;

public interface ProductService {
	List<Product> getProduct();

	boolean saveProduct(Product product);

	void deleteProduct(long id);

	Product updateProduct(Product product);

	Product getProductById(long id);
}
