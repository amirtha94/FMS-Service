
package com.fms.fmsevent;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

import com.mongodb.reactivestreams.client.MongoClients;

public class MongoConfig extends AbstractReactiveMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "fms_event";
	}

	public @Bean ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {
	    return new SimpleReactiveMongoDatabaseFactory(MongoClients.create("mongodb://admin:admin@localhost:27017"), getDatabaseName());
	  }

	  public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
	    return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
	  }
}
