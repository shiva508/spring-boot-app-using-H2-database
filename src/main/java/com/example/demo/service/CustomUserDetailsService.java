/*package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomUser;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@Service
public class CustomUserDetailsService  implements UserDetailsService{
	@Autowired
	UserRepository usserRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user=usserRepository.findByName(username);
		user.orElseThrow(()-> new UsernameNotFoundException("User is Not Found With Name:"+username));
		return user.map(CustomUser::new).get();
	}

}
*/