package com.ki.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ki.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	public List<Employee> findAll();
}