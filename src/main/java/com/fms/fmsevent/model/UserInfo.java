package com.fms.fmsevent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

	
	private String employeeId;	
	
	private String email;
	
	private String mobileNo;
	
	private String EmpName;
	
	private String username;
	
	private String password;

	@JsonIgnore
	private boolean enabled;
	
	@JsonIgnore
	private String role;
}
