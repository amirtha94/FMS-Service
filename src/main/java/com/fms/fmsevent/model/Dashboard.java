package com.fms.fmsevent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dashboard {

	private int totalevents;

	private int totalVolunteersCount;

	private int totalLivesImpacted;

	private int totalParticipants;

}
