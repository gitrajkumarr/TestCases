package com.testcase.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.testcase.customException.ResourceNotFoundException;
import com.testcase.entity.Student;
import com.testcase.model.ResponseVO;
import com.testcase.services.StudentService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class StudentController {
	
	private static final String Service="studentService";
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/greetings")
	public String hello() {
		return "hello from controller";
	}
    int count =0;
	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public Student saveStudent(@RequestBody Student student) {
		return service.save(student);

	}

	@GetMapping("/student")
	public List<Student> fetchStdudent() {
		return service.fetchAll();
	}

	@GetMapping("/student/{sId}")
	public ResponseVO fetchStdudent(@PathVariable long sId) throws ResourceNotFoundException {
		return service.feetchById(sId);
		
	}
	@GetMapping("/student/resilience")
	//@CircuitBreaker(name = Service , fallbackMethod = "studentServiceFallback")
	@Retry(name = Service)
	public String fetchStudent() {
		log.info("Retry count ::"+ count++ +"Time::"+ new Date()+"");

		return restTemplate.getForObject("http://localhost:8082/", String.class);
	}
	
	public String studentServiceFallback(Exception e) {
		return "this is from fallback method of student Service";
	}
	
	

}
