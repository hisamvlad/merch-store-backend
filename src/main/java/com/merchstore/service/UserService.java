package com.merchstore.service;

import java.util.Set;

import com.merchstore.domain.ERole;
import com.merchstore.domain.User;

public interface UserService {
	User createUser (User user, Set<ERole> userRoles);

    User save (User user);

    User findById (Long id);

    User findByUsername (String username);

    User findByEmail(String email);

    
}
