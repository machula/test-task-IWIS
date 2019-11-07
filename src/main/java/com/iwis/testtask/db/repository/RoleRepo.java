package com.iwis.testtask.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.iwis.testtask.db.entity.Role;

@Service
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
