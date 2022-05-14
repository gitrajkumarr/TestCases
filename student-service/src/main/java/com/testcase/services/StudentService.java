package com.testcase.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.testcase.customException.ResourceNotFoundException;
import com.testcase.entity.Student;
import com.testcase.model.ResponseVO;

@Service
public interface StudentService {
	
	public Student save(Student student);

	public List<Student> fetchAll();
	
	public ResponseVO feetchById(long sId) throws ResourceNotFoundException;	

}
