package com.utrack.backend.hibernate.config;

import org.springframework.beans.factory.annotation.Value;

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
	private String hbm2ddl_auto;
	
	@Value("${entitymanager.packagesToScan}")
	private String entityManager_packes_to_scan;

}
