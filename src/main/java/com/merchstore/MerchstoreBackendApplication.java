package com.merchstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.merchstore.config.SecurityUtility;
import com.merchstore.domain.security.Role;
import com.merchstore.domain.security.User;
import com.merchstore.domain.security.UserRole;
import com.merchstore.service.UserService;

@SpringBootApplication
public class MerchstoreBackendApplication  implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MerchstoreBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Set<UserRole> userRoles = new HashSet<>();
		
		// Add users
		 //user 1 = admin
		User user1 = new User();
		user1.setFirstName("Admin");
		user1.setLastName("Admin");
		user1.setUsername("Admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("Admin@gmail.com");
		Role role1 = new Role();
		role1.setName("ROLE_ADMIN");
		role1.setRoleId(0);
		userRoles.add(new UserRole(user1, role1));
		// TODO implement user creation service
		userService.createUser(user1, userRoles);
		
		//user2 = Jon Doe
		User user2 = new User();
		user2.setFirstName("Jon");
		user2.setLastName("Doe");
		user2.setUsername("JD");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user2.setEmail("Jd@gmail.com");
		Role role2 = new Role();
		role2.setRoleId(1);
		role2.setName("ROLE_USER");
		userRoles.add(new UserRole(user2, role2));
		// TODO implement user creation service
				userService.createUser(user2, userRoles);
	}

}
