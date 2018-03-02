package com.practice.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.data.jpa.repository.config.*;

public class AppConfig {

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;
	
	@Bean(name="entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory () {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.practice.entity");
		emf.setPersistenceUnitName("customer-crud");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(additionalProperties());
		return emf;
	}

	@Bean(name="transactionManager")
	@Primary
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}
	
	
	@Bean
	public Properties additionalProperties () {
		return new Properties () {
			{
				setProperty("hibernate.dialect", env.getProperty("customer.hibernate.dialect"));
				setProperty("spring.jpa.hibernate.ddl-auto", env.getProperty("create-drop"));
				setProperty("spring.jpa.properties.hibernate.default_schema", env.getProperty("spring.jpa.properties.hibernate.default_schema"));
				setProperty("hibernate.default_schema", env.getProperty("spring.jpa.properties.hibernate.default_schema"));
			}
			
		};
	}
	
	
}