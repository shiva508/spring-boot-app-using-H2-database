package com.example.demo.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.sql.PooledConnection;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.zaxxer.hikari.pool.HikariPool;

public class JPAConfiguration {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("");
		dataSource.setUrl("");
		dataSource.setUsername("");
		dataSource.setPassword("");
	
		return dataSource;
	}

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	
		LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
		lef.setDataSource(dataSource());
		lef.setPackagesToScan("");
		lef.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lef.setJpaProperties(jpaProperties());
		return lef;
	}

	public Properties jpaProperties() {
		Properties jpa = new Properties();
		return jpa;
	}

	@Bean
	public JpaTransactionManager txManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return txManager;
	}
}
