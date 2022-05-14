package com.testcase.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.testcase.customException.ResourceNotFoundException;
import com.testcase.entity.Student;
import com.testcase.model.Department;
import com.testcase.model.ResponseVO;
import com.testcase.repositary.StudentRepositary;

@Service
public class StudnetServiceImpl implements StudentService {

	@Autowired
	private StudentRepositary repo;
	
	@Autowired
	private ResponseVO vo;
	
	public Student save(Student student) {
		return repo.save(student);
	}

	public List<Student> fetchAll() {
		return repo.findAll();
	}
	
	

	@Override
	public ResponseVO feetchById(long sId) throws ResourceNotFoundException{		
	
		Optional<Student> student = Optional.ofNullable(repo.fetchIdusingCustomQuery(sId));
		if (!student.isPresent()) {
			throw new ResourceNotFoundException("Data Not Found");
		}
		
		Department dept = new RestTemplate().getForObject("http://localhost:8082/departments/"+student.get().getDepartmentId(), Department.class);
		
		vo.setDept(dept);
		vo.setStudent(student.get());
		return vo;

	}

}
