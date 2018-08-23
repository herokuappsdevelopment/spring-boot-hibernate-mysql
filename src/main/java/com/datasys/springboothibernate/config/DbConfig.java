package com.datasys.springboothibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@PropertySource(value = { "classpath:application.properties" })
@Configuration
public class DbConfig {

	@Value("${jdbc.driverClassName}")
	private String driverClass;

	@Value("${jdbc.username}")
	public String userName;

	@Value("${jdbc.password}")
	public String password;

	@Value("${jdbc.url}")
	public String url;

	@Value("${hibernate.dialect}")
	public String dialect;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, userName, password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(hibernateProperties());
		factory.setPackagesToScan(new String[] { "com.datasys.springboothibernate.model" });
		return factory;

	}

	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.putIfAbsent("hibernate.dialect", dialect);
		properties.putIfAbsent("hibernate.hbm2ddl.auto", "create");
		properties.putIfAbsent("hibernate.show_sql", "true");
		properties.putIfAbsent("hibernate.format_sql", "true");

		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {

		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();

		hibernateTransactionManager.setSessionFactory(factory);

		return hibernateTransactionManager;
	}
	
}
