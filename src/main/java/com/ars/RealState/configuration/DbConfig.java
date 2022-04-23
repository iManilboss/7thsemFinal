package com.ars.RealState.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DbConfig {
	
	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/realestate_db");
		ds.setUsername("root");
		ds.setPassword("");
		return ds;
	}
	
	
	public Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.show_sql", "true");
		return props;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(getDataSource());
		sf.setHibernateProperties(getHibernateProperties());
		sf.setPackagesToScan("com.ars.RealState.model");
		return sf;
		
	}
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		HibernateTransactionManager tm = new HibernateTransactionManager();
		tm.setSessionFactory(getSessionFactory().getObject());
		return tm;
	}
	

}
