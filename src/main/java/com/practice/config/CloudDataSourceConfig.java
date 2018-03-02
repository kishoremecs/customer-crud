package com.practice.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.PlatformTransactionManager;

import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.data.jpa.repository.config.*;

import org.apache.tomcat.jdbc.pool.*;

@Configuration
@Profile("cloud")
public class CloudDataSourceConfig extends AbstractCloudConfig {

	@Autowired
	private Environment env;

	@Bean(name="dataSource")
	@Primary
    public DataSource inventoryDataSource() {
        return connectionFactory().dataSource("my-postgres");
    }
	/*public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(env.getProperty("datasource.customer.driverClassName"));
		dataSource.setUrl(env.getProperty("datasource.customer.primary.url"));
		dataSource.setUsername(env.getProperty("datasource.customer.username"));
		dataSource.setPassword(env.getProperty("datasource.customer.password"));
		return dataSource;
	}*/

	
}

