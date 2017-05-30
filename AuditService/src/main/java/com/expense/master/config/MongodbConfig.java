package com.expense.master.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories(basePackages = "com.expense.master.model.mongod.repository")
public class MongodbConfig extends AbstractMongoConfiguration {

	@Value("${spring.data.mongodb.host}")
	private String mongohost;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

	@Override
	protected String getDatabaseName() {
		return databaseName;
	}

	@Override
	@Bean
	public MongoClient mongo() throws Exception {
			MongoClient client = new MongoClient(mongohost);
		client.setWriteConcern(WriteConcern.SAFE);
		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), getDatabaseName());
	}

}
