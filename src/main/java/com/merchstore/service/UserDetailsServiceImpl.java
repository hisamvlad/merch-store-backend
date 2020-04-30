package com.merchstore.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.merchstore.domain.User;
import com.merchstore.repository.UserRepository;

//we get full custom User object using UserRepository, 
//then we build a UserDetails object using static build() method.

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
		
	@Autowired
	private UserRepository userRepository;

	//Getting full custom User object using UderRepository and 
	// build UserDetails object using static build() method
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// retrieve user from Db or else throw an exception
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User" + username + " Not Found"));
		
		return UserDetailsImpl.build(user);
	
	}
	 
}
