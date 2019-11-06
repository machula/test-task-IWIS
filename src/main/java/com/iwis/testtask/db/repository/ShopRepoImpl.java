package com.iwis.testtask.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.iwis.testtask.db.entity.Shop;

@Service
@Repository
public interface ShopRepoImpl extends JpaRepository<Shop, Integer>{

}
