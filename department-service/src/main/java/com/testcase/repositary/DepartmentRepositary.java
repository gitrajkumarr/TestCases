package com.testcase.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testcase.entity.Department;

@Repository
public interface DepartmentRepositary  extends JpaRepository<Department, Long>{

	public Department getByName(String name);

}
