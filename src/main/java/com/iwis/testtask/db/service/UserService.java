package com.iwis.testtask.db.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.iwis.testtask.db.entity.User;
import com.iwis.testtask.db.repository.UserRepoImpl;

public interface UserService {

	User findOne(int id);

	void delete(int id);

	User save(User user);
	
	
}
