package com.ki.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ki.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}