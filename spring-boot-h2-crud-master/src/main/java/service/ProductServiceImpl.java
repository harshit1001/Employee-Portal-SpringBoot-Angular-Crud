package service;

import br.com.crud.demo.service.ProductService;
import models.Product;
import repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.websocket.Session;

@Service
public class ProductServiceImpl implements ProductService {

	@PersistenceContext
	private EntityManager em;

	public Product post(Product entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> get() {

		return em.createQuery("from Product").getResultList();

	}

	@Transactional
	public int put(Product member) {
		// code
		em.persist(member);
		return 1;
	}
	
	@Transactional
	public int edit(Product member) {
		// code
		em.merge(member);
		return 1;
	}


	@Transactional
	public int delete(int id) {

		Product employee = em.find(Product.class, id);

		em.remove(employee);

		return 1;

	}
	@Transactional
	public void saveAll(List<Product>products){
	
		products.forEach((e)->{
			Product employee = em.find(Product.class, e.id);
			if(employee!=null) {em.merge(e);}
			else {em.persist(e);}
			});
		
	}

}
