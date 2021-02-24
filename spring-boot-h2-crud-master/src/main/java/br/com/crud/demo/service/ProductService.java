package br.com.crud.demo.service;

import java.util.List;

import interfaces.GenericOperations;
import models.Product;

public interface ProductService extends GenericOperations<Product> {

	int edit(Product entity);

	void saveAll(List<Product> tutorials);
	
	
}
