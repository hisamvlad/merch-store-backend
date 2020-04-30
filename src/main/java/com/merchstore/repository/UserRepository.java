package com.merchstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.merchstore.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
//	User findByEmail(String email);
//	List<User> findAll();
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	

}
