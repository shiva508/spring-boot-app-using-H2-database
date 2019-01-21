
package com.example.demo.config.h2db;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

// this is what happens internally for database auto-configuration 
// used to jdbc authentication 
/*@Configuration*/
public class H2databaseconfig {
/*	@Bean*/
public DataSource dataSource() {
	EmbeddedDatabaseBuilder builder=new EmbeddedDatabaseBuilder();
	return builder.setType(EmbeddedDatabaseType.H2).build();
}
	/*@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	HibernateJpaVendorAdapter vendoradoptor=new HibernateJpaVendorAdapter();
	vendoradoptor.setDatabase(Database.H2);
	LocalContainerEntityManagerFactoryBean beangfactory=new LocalContainerEntityManagerFactoryBean();
	beangfactory.setJpaVendorAdapter(vendoradoptor);
	beangfactory.setPackagesToScan("com.example.demo.model");
	beangfactory.setDataSource(dataSource());
	return beangfactory;
	}
	@Bean
	PlatformTransactionManager transactionmanager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager manager=new JpaTransactionManager();
		manager.setEntityManagerFactory(entityManagerFactory);
		return manager;
	}*/
}
