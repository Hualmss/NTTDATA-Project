package com.nttdata.movimients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.movimients.model.Product;
import  com.nttdata.movimients.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping(value = "Product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getProduct() {
		return new ResponseEntity<>(productService.getProduct(), HttpStatus.OK);
	}

	@PostMapping(value = "Product", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveProduct(@RequestBody Product product) {

		productService.saveProduct(product);
	}

	@PutMapping(value = "Product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		if (productService.getProductById(id) == null) {
			return null;
		}
		return productService.updateProduct(product);
	}

	@DeleteMapping(value = "Product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> deleteProduct(@PathVariable long id) {
		if (productService.getProductById(id) == null) {
			return null;

		}
		productService.deleteProduct(id);
		return productService.getProduct();

	}


}
