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
import com.iwis.testtask.db.repository.ShopRepoImpl;

@RestController
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopRepoImpl shopRepo;
	
	@GetMapping(value = "/get/all")
	public List<Shop> getAll(){
		return shopRepo.findAll();		
	}
	@GetMapping(value = "/get/{id}")
	public Optional<Shop> getById(@PathVariable String id){
		return shopRepo.findById(Integer.parseInt(id));		
	}
	@GetMapping(value = "/get/products/{id}")
	public Set<Product> getProductsById(@PathVariable String id){
		return shopRepo.findById(Integer.parseInt(id)).get().getProducts();	
	}
	@PostMapping(value = "/add")
	public void create(@RequestBody Shop shop) {
		shopRepo.saveAndFlush(shop);
	}
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@RequestBody Shop shop) {
		shopRepo.delete(shop);
	}

}
