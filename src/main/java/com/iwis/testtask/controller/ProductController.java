package com.iwis.testtask.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iwis.testtask.db.entity.Product;
import com.iwis.testtask.db.entity.Shop;
import com.iwis.testtask.db.repository.ProductRepoImpl;

@RestController
@RequestMapping("main/product")
public class ProductController {
	
    public static final String ROLE_USER = "ROLE_USER";
	
	@Autowired
	private ProductRepoImpl productRepo;
	
	@Secured({ROLE_USER})
	@GetMapping(value = "/get/all")
	public List<Product> getAll(){
		return productRepo.findAll();		
	}
	@Secured({ROLE_USER})
	@GetMapping(value = "/get/{id}")
	public Optional<Product> getById(@PathVariable String id){
		return productRepo.findById(Integer.parseInt(id));		
	}
	@Secured({ROLE_USER})
	@GetMapping(value = "/get/shops/{id}")
	public Set<Shop> getShopsById(@PathVariable String id){
		return productRepo.findById(Integer.parseInt(id)).get().getShops();	
	}
	@Secured({ROLE_USER})
	@PostMapping(value = "/add")
	public void create(@RequestBody Product product) {
		productRepo.saveAndFlush(product);
	}
	@Secured({ROLE_USER})
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@RequestBody Product product) {
		productRepo.delete(product);
	}
}
