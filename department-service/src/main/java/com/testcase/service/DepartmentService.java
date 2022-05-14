package com.testcase.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testcase.entity.Department;
import com.testcase.repositary.DepartmentRepositary;

@Service

public class DepartmentService {

	@Autowired
	private DepartmentRepositary repositary;
	
	public Department saveDep(Department dept) {		
		return repositary.save(dept);
	}

	public Department getById(long id) {		
		return repositary.findById(id).get();		
	}
	public Department getByName(String name) {
		return repositary.getByName(name);
	}

}
