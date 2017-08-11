package com.config;


import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dao.UserDao;
import com.daoimpl.UserDaoImpl;
//import com.model.Category;
import com.model.User;

@Configuration
@ComponentScan("com.*")
@EnableTransactionManagement
public class hibernateConfig {
	
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getH2DataSource() 
	{
		System.out.println("Data source method");    
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		System.out.println("Database is connected.....!");
		return dataSource;

	}
	
	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.show_sql", "true");	 // NOT typing any SQL 	
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		System.out.println("Hibernate Properties");
		return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	 sessionBuilder.addAnnotatedClasses(User.class);



	   // sessionBuilder.addAnnotatedClasses(Category.class);
	    return sessionBuilder.buildSessionFactory();

	}
	
	@Autowired
	@Bean(name="UserDaoImpl")
	public UserDaoImpl getUserDAO(SessionFactory sessionFactory)
	{
		return new UserDaoImpl(sessionFactory);
	}
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//		System.out.println("Transaction");
//		return transactionManager;
//	}
	
	
}