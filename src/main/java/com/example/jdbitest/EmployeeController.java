package com.example.jdbitest;

import java.util.List;

import com.example.jdbitest.entity.Employee;
import com.example.jdbitest.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController{

	@Autowired
	private EmployeeRepository er;

	@GetMapping
	public List<Employee> get(){
		
		return er.findAll();
	}

	@PostMapping
	public Employee post(@RequestBody Employee e){
		
		int id = er.insertEmployee(e);
		return er.findById(id);
	}
}