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
public class EmployeeDetails {

	@Id
	private String employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String emailid;
	
	
}
