package com.testcase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testcase.entity.Department;
import com.testcase.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department dept) {		
		return service.saveDep(dept);		
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartment(@PathVariable long id) {		
		return service.getById(id);		
	}
	@GetMapping("/departmentsByname/{name}")
	public Department getDepartment(@PathVariable String name) {		
		return service.getByName(name);		
	}
	
	@GetMapping("/")
	public String deptService() {
		return "department service";
	}


}
