package com.fms.fmsevent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document //Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {

	@Id
	private String eventId;
	
	private String month;
	
	private String venueAddress;
	
	private String project;
	
	private String eventDate;
	
	private String totalVolunteers;
	
	private String totalVolunteersHours;
	
	private String totalTravelHours;
	
	private String livesImpacted;
	
	private String overallVolunteerHours;
	
	private String activityType;
	
	private String status;
	
	private pocDetails pocDetail;
	
}
