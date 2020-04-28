package com.fms.fmsevent.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.fms.fmsevent.model.EventDetail;

public interface EventDetailsRepository extends ReactiveMongoRepository<EventDetail, String>{

}
