package com.fms.fmsevent.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class pocDetails {

	@Id
	private String pocId;
	
	private String pocName;
	
	private String pocNumber;
	
}
