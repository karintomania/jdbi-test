package com.example.jdbitest.repository;

import java.util.List;

import com.example.jdbitest.entity.Employee;

import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {

    private EmployeeJdbiRepository ejr;

    public EmployeeRepository(Jdbi jdbi) {
        this.ejr = jdbi.onDemand(EmployeeJdbiRepository.class);
    }

    public int insertEmployee(Employee employee) {
        return ejr.insertEmployee(employee);
    }

    public Employee findById(int id) {
        return ejr.findById(id);
	}
	
    public List<Employee> findAll() {
        return ejr.findAll();
	}
}