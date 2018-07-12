package com.utrack.backend.hibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.utrack.backend.common.AuditLogInterceptor;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	@Value("${db.driver}")
	private String db_driver;

	@Value("${db.password}")
	private String db_password;

	@Value("${db.url}")
	private String db_url;

	@Value("${db.username}")
	private String db_username;

	@Value("${hibernate.dialect}")
	private String hibernate_dialect;

	@Value("${hibernate.show_sql}")
	private String hibernate_show_sql;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernate_hbm2ddl_auto;

	@Value("${entitymanager.packagesToScan}")
	private String entityManager_packes_to_scan;

	@Autowired
	private AuditLogInterceptor auditLogInterceptor;

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(db_driver);
		dataSource.setUrl(db_url);
		dataSource.setUsername(db_username);
		dataSource.setPassword(db_password);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(entityManager_packes_to_scan);
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", hibernate_dialect);
		hibernateProperties.setProperty("hibernate.show_sql", hibernate_show_sql);
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernate_hbm2ddl_auto);
		hibernateProperties.put("hibernate.session_factory.interceptor", auditLogInterceptor);
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
