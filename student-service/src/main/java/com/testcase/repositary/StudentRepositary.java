package com.testcase.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testcase.entity.Student;

@Repository
public interface StudentRepositary  extends JpaRepository<Student, Integer>{

	@Query(value ="select * from student where id = :sId",nativeQuery = true)
	public Student fetchIdusingCustomQuery(long sId);
	
}
