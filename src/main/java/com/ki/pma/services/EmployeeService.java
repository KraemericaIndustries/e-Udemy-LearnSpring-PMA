package com.ki.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ki.pma.dao.EmployeeRepository;
import com.ki.pma.dto.EmployeeProject;
import com.ki.pma.entities.Employee;

@Service
public class EmployeeService {

	//  Field Injection
	@Autowired
	EmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll() {
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects() {
		return empRepo.employeeProjects();
	}
}