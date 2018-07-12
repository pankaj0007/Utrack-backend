package com.utrack.backend.hibernate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;

@Configuration
@Component
public class MongoConnection {

	@Value("${mongodb.host}")
	private String mongoHost;

	@Value("${mongodb.database}")
	private String mongoDB;

	@Value("${mongodb.username}")
	private String mongoUsername;

	@Value("${mongodb.password}")
	private String mongoPassword;

	@Value("${mongodb.port}")
	private int mongoPort;

	@Bean
	public MongoDbFactory mongoDbFactory() {
		MongoClient mongoClient = new MongoClient(mongoHost, mongoPort);
		return new SimpleMongoDbFactory(mongoClient, mongoDB);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		// remove _class
		MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);
		return mongoTemplate;
	}
}
