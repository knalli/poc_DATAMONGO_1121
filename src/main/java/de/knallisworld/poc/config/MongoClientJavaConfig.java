package de.knallisworld.poc.config;

import java.io.IOException;
import java.util.Properties;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "de.knallisworld.poc.mongo.repository", createIndexesForQueryMethods = false)
public class MongoClientJavaConfig {

	@Autowired
	private Properties mongoProperties;

	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		return new MongoTemplate(mongo(), mongoProperties.getProperty("mongodb.database"));
	}

	@Bean
	public MongoClient mongo() throws IOException {
		return new MongoClient("localhost", Integer.parseInt(mongoProperties.getProperty("mongodb.port")));
	}
}
