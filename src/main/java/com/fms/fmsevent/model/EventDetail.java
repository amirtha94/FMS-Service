package com.fms.fmsevent.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetail {

	@JsonIgnore
	private String id;
	
	private String eventId;
	
	private String baseLocation;
	
	private String beneficiaryName;
	
	private String councilName;
	
	private String eventName;
	
	private String eventDescription;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate eventDate;
	
	private int employeeId;
	
	private String employeeName;
	
	private double volunteerHours;
	
	private double travelHours;
	
	private double livesImpacted;
	
	private String businessUnit;
	
	private String status;
	
	private String iiep;
}
