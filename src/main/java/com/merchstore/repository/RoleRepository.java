package com.merchstore.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.merchstore.domain.ERole;
import com.merchstore.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Optional<Role> findByName(ERole name);
	

}
