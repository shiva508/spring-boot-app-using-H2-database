/*package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomUserJdbcDetails;
import com.example.demo.model.UserJdbc;
import com.example.demo.repository.RoleJdbcRepository;
import com.example.demo.repository.UserJdbcRepository;
@Service
public class CustomUserJdbcDetailsServive implements UserDetailsService{
	@Autowired
	UserJdbcRepository userJdbcRepository;
	@Autowired
	RoleJdbcRepository roleJdbcRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserJdbc user=userJdbcRepository.findByUserNameUser(username);
		if(user==null) {
			throw new UsernameNotFoundException("USER NOT FOUND"); 
		}
		else {
			List<String> userRoles=roleJdbcRepository.getRolesByUserName(username);
			System.out.println(userRoles.toString());
			return new CustomUserJdbcDetails(user, userRoles);
		}
		
	}

}
*/