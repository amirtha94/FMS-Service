package com.fms.fmsevent.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackQuestion {

	@Id
	@JsonProperty("question")
	private String fbQuestion;
	
	@JsonProperty("feedback-type")
	@JsonInclude(Include.NON_EMPTY)
	private String fbType;
	
	@JsonInclude(Include.NON_EMPTY)
	private List<FeedbackAnswer> answers;
	
	@JsonInclude(Include.NON_EMPTY)
	private String total_answers;
}
