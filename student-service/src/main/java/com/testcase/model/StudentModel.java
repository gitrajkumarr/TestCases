package com.testcase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class StudentModel {	
	private String firstname;
	private String lastname;
	private String emailId;
	private long deptid;
}
