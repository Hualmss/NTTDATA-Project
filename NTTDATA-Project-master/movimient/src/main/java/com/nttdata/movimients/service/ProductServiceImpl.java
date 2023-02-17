package com.nttdata.movimients.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.movimients.model.Product;
import com.nttdata.movimients.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	@Override
	public boolean saveProduct(Product product) {
		productRepository.save(product);
		return true;
	}

	@Override
	public void deleteProduct(long id) {
		productRepository.deleteById(id);

	}

	@Override
	public Product updateProduct(Product product) {
		return productRepository.save(product);

	}

	@Override
	public Product getProductById(long id) {
		return productRepository.findById(id).orElseThrow();
	}

}
