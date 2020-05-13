package com.merchstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merchstore.domain.Merch;
import com.merchstore.repository.MerchRepository;
import com.merchstore.service.MerchService;

@Service
public class MerchServiceImpl implements MerchService {
	
	@Autowired
	private MerchRepository merchRepository;

	@Override
	public List<Merch> findAll() {
		List<Merch> merchList = (List<Merch>) merchRepository.findAll();
		
		List<Merch> activeMerchList = new ArrayList<>();
		
		merchList.forEach(Merch -> {
			if(Merch.isActive()) {
				activeMerchList.add(Merch);
			}
		});
		
		return activeMerchList;
	}

	@Override
	public Optional<Merch> findOne(Long id) {
		return merchRepository.findById(id);
	}

	@Override
	public Merch save(Merch merch) {
		return merchRepository.save(merch);
	}

	@Override
	public List<Merch> blurrySearch(String keyword) {
		List<Merch> merchList = merchRepository.findByNameContaining(keyword);
		
		List<Merch> activeMerchList = new ArrayList<>();
		
		merchList.forEach(Merch -> {
			if(Merch.isActive()) {
				activeMerchList.add(Merch);
			}
		});
		return activeMerchList;
	}

	@Override
	public void removeOne(Long id) {
		merchRepository.deleteById(id);
		
	}

}
