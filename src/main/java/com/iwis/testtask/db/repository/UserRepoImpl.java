package com.iwis.testtask.db.repository;

import org.springframework.data.repository.CrudRepository;

import com.iwis.testtask.db.entity.User;

public interface UserRepoImpl extends CrudRepository<User, Integer>{
	User findByUsername(String username);
    User findByEmail(String email);
}
