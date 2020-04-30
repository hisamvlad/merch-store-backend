package com.merchstore.config.jwt;

import java.security.SignatureException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.merchstore.service.UserDetailsImpl;
import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import io.jsonwebtoken.*;


@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
  
  @Value("${jwt.secret}")
  private String jwtSecret;
  
  @Value("${jwt.expiration}")
  private int jwtExpirationMs;
  
  public String generateJwtToken(Authentication authentication) {
	  
	  UserDetailsImpl userPrincipal = (UserDetaisImpl) authentication.getPrincipal();
	  
	  return Jwts.builder()
			  .setSubject((userPrincipal.getUsername()))
			  .setIssuedAt(new Date())
			  .setExpiration(new Date()).getTime() + jwtExpirationMs))
			  .setWith(SignatureAlgorithm.HS512, jwtSecret)
			  .compact();
	  
  }
  
  public String getUserNameFromJwtToken(String authToken) {
	  try {
		  Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
		  return true;
	  } catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
	  }
	  return false;
  }
}
