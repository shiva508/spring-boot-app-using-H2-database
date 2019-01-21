/*package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import com.example.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecuritySidteMinderConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	
*//**
	 * customUserDetailsService integrates spring security with siteminder
	 *//*
	@Bean
	public UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> preAuthUserDetails() {
		UserDetailsByNameServiceWrapper<PreAuthenticatedAuthenticationToken> token = new UserDetailsByNameServiceWrapper<>();
		token.setUserDetailsService(customUserDetailsService);
		return token;
	}

	
	*//**
	 * PrauthenticationProvider Bean for getting user details from using customUserDetailsService
	 *//*
	@Bean
	public PreAuthenticatedAuthenticationProvider preAuthProvider() {
		PreAuthenticatedAuthenticationProvider provider = new PreAuthenticatedAuthenticationProvider();
		provider.setPreAuthenticatedUserDetailsService(preAuthUserDetails());
		return provider;
	}
	
	*//**
     * Registers authentication manager as spring bean which is required for method level security
     *//*

	@Bean(name = "authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	*//**
     * This will be called by spring security internally as callback method
     * to register user defined authentication provider
     *//*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(preAuthProvider());
	}
	*//**
     * This pre-authentication filter uses authentication manager to get user details with authorities
     * from CustomUser component, creates PrauthenticationToken with userdetail and stores it in  securityContext
     *//*
	@Bean
	public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter() throws Exception {
		RequestHeaderAuthenticationFilter filter = new RequestHeaderAuthenticationFilter();
		filter.setPrincipalRequestHeader("SM_USER");
		System.out.println("WELCOMA");
		filter.setAuthenticationManager(authenticationManager());
		return filter;

	}
	 *//**
     * This method configures static contents so that they can be ignored by spring security.
     *//*
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/component/**", "/admin/images/**");
	}
	*//**
     * This will be called by spring security as callback method
     * to registers filters and authorize requests for different roles (business activities)
     *//*
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console/login.jsp").permitAll()
		.antMatchers("/getAllUsers").permitAll()
		.antMatchers("/getAllRoles").permitAll()
		.antMatchers("/getAllEmployees").permitAll()
				.anyRequest().authenticated().antMatchers("/getAll").access("hasRole('ADMIN')")
				.and()
				.exceptionHandling().accessDeniedPage("/error")
				.and()
				.addFilter(requestHeaderAuthenticationFilter());

	}
}
*/