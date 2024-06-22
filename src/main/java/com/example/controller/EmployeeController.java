package com.example.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private EmployeeRepository repo;

	public EmployeeController(EmployeeRepository repo) {
		this.repo = repo;
	}

	@PostMapping(value = "/employee", consumes = { "application/json", "application/xml" })
	public Employee add(@RequestBody Employee emp) {
		repo.save(emp);
		return repo.findById(emp.getEmpId());
	}

	@GetMapping(value = "/employees")
	public Map<Integer, Employee> getAll() {
		return repo.findAll();
	}

	@DeleteMapping(value = "/employee/{eid}")
	public Map<Integer, Employee> deleteData(@PathVariable("eid") int eid) {
		repo.deleteData(eid);
		return repo.findAll();
	}

	@PutMapping(value = "/employee")
	public Map<Integer, Employee> updateData(@RequestBody Employee emp) {
		repo.save(emp);
		return repo.findAll();
	}

}
