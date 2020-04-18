package com.merchstore.domain.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority, Serializable{

	// Unique identifier for a serializable class
	//  ensures that a loaded class is compatible with the serialized object.
	private static final long serialVersionUID = 123456L;
	
	// would be used
	// to represent an authority granted to an Authentication object
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}
}
