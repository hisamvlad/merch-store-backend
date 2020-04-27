package com.merchstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.merchstore.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {


	

}
