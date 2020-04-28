package com.fms.fmsevent.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fms.fmsevent.model.Events;

public interface EventsRepository extends ReactiveMongoRepository<Events, String>{

	
}
