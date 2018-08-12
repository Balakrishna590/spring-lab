package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackages = "com.demo.spring.dao")
@ComponentScan(basePackages = "com.demo.spring")
public class MongoConfig {
	
	@Bean
	public MongoClient mongoClient() {

		MongoClient mc = new MongoClient(new ServerAddress("localhost", 27017));
		return mc;
	}
	
	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mt=new MongoTemplate(mongoClient(), "test");
		return mt;
	}
}
