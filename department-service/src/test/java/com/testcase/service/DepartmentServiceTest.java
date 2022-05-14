package com.testcase.service;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcase.entity.Department;
import com.testcase.repositary.DepartmentRepositary;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentRepositary repo;
	
	@Test
	void testToPostDepartment() {
		Department department=Department.builder().id(1).name("ece").build();
		repo.save(department);
	}

}
