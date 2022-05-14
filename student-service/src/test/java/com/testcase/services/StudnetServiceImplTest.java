package com.testcase.services;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcase.entity.Student;
import com.testcase.model.StudentModel;
import com.testcase.repositary.StudentRepositary;

import lombok.Builder;

@SpringBootTest
class StudnetServiceImplTest {

	@Autowired
	private StudentRepositary repo;	
	
	
	@Test
	void testtoPostStudentData() {
	
			StudentModel model =  StudentModel.builder()
					.firstname("rajkumar")
					.lastname("ramaraj")
					.emailId("rjkumar.ec@gmail.com")
					.deptid(1)
					.build();
			Student student = new Student();
			student.setFirstname(model.getFirstname());
			student.setLastname(model.getLastname());
			student.setEmailId(model.getEmailId());
			student.setDepartmentId(model.getDeptid());
			
		repo.save(student);
	}

}
