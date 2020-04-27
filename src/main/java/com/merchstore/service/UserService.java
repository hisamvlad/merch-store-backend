package com.merchstore.service;

import java.util.Set;

import com.merchstore.domain.User;
import com.merchstore.domain.security.UserRole;

public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);
}
