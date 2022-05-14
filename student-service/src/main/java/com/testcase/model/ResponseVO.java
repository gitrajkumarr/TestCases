package com.testcase.model;

import org.springframework.stereotype.Component;

import com.testcase.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseVO {
	
	private Student student;
	private Department dept;

}
