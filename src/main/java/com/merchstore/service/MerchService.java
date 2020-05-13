package com.merchstore.service;

import java.util.List;
import java.util.Optional;

import com.merchstore.domain.Merch;

public interface MerchService {

	List<Merch> findAll();
	
	Optional<Merch> findOne(Long id);
	
	Merch save(Merch merch);
	
	List<Merch> blurrySearch(String title);
	
	void removeOne(Long id);
}
