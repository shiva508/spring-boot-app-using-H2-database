/*package com.example.demo.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SampleAuthenticationManager implements AuthenticationManager {
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("Credentials:" + authentication.getCredentials());
		System.out.println("Name:" + authentication.getName());
		System.out.println("Authorities:" + authentication.getAuthorities());
		System.out.println("Details:" + authentication.getDetails());
		System.out.println("getPrincipal:" + authentication.getPrincipal());
		if (authentication.getName().equals(authentication.getCredentials())) {
			return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(),
					AUTHORITIES);
		}
		throw new BadCredentialsException("Bad Credentials");
	}

}
*/