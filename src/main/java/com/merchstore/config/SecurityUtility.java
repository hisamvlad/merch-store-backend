package com.merchstore.config;

import java.security.SecureRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	
	//https://docs.spring.io/spring-security/site/docs/3.1.x/reference/crypto.html
	private static final String SALT = KeyGenerators.string().generateKey(); // generates a random 8-byte salt that is then hex-encoded
	//Salt adds an extra string in password so hacker find it difficult for breaking the password
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
}
