package com.example.jdbitest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import com.example.jdbitest.entity.Employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeControllerTest {

	@Autowired
	EmployeeController ec;

	@Test
	void getTest() {

		List<Employee> expectedEmployees = Arrays.asList(new Employee[]{
												new Employee(1,"tarou","satou"),
												new Employee(2,"jirou","suzuki")
											});
		List<Employee> employees = ec.get();

		int i = 0;
		
		for(Employee e:employees){
			assertEquals(e,expectedEmployees.get(i++));
		}
		
	}

	@Test
	void postTest(){
		Employee e = new Employee(3,"tarou","test"); 
		Employee result = ec.post(e);

		assertEquals(e,result);
	}

}
