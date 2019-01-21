/*package com.example.demo.config;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.service.CustomUserJdbcDetailsServive;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@EnableJpaRepositories(basePackages= {"com.example.demo.repository"})
public class SpringSecurityJDBCConfig extends WebSecurityConfigurerAdapter {
@Autowired
	CustomUserJdbcDetailsServive customUserJdbcDetailsServive;
@Autowired
DataSource dataSource;
	@Autowired
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserJdbcDetailsServive).passwordEncoder(getPasswordEncoder());
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select USER_NAME,PASSWORD, ENABLED from user_jdbc where USER_NAME=?")
		.authoritiesByUsernameQuery("select USER_NAME, ROLE from roles_jdbc where USER_NAME=?").passwordEncoder(getPasswordEncoder());
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/getAll").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/getaaluserjdbc").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.anyRequest().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403");
	}
}
*/