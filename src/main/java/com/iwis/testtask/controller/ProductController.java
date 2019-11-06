package com.iwis.testtask.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductRepoImpl productRepo;
	
	@GetMapping(value = "/get/all")
	public List<Product> getAll(){
		return productRepo.findAll();		
	}
	@GetMapping(value = "/get/{id}")
	public Optional<Product> getById(@PathVariable String id){
		return productRepo.findById(Integer.parseInt(id));		
	}
	@GetMapping(value = "/get/shops/{id}")
	public Set<Shop> getShopsById(@PathVariable String id){
		return productRepo.findById(Integer.parseInt(id)).get().getShops();	
	}
	@PostMapping(value = "/add")
	public void create(@RequestBody Product product) {
		productRepo.saveAndFlush(product);
	}
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@RequestBody Product product) {
		productRepo.delete(product);
	}
}
