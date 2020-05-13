package com.merchstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.merchstore.domain.Merch;

public interface MerchRepository extends CrudRepository<Merch, Long> {

	Optional<Merch> findById(Long id);
	
	List<Merch> findByNameContaining(String keyword);
	
	List<Merch> findByCategory(String category);
}
