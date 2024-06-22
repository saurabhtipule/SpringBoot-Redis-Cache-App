package com.example.repository;

import java.util.Map;

import com.example.model.Employee;

public interface EmployeeRepository {

	Employee findById(int empId);

	void save(Employee emp);

	Map<Integer, Employee> findAll();

	void deleteData(int eid);
	
}
