package com.example.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.example.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private HashOperations<String, Integer, Employee> hashOps;

	public EmployeeRepositoryImpl(RedisTemplate<String, Employee> redisTemplate) {
		hashOps = redisTemplate.opsForHash();
	}

	@Override
	public Employee findById(int empId) {
		return hashOps.get("EMPLOYEE", empId);
	}

	@Override
	public void save(Employee emp) {
		hashOps.put("EMPLOYEE", emp.getEmpId(), emp);
	}

	@Override
	public Map<Integer, Employee> findAll() {
		return hashOps.entries("EMPLOYEE");
	}

	@Override
	public void deleteData(int eid) {
		hashOps.delete("EMPLOYEE", eid);
	}

}
