package com.ki.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ki.pma.dao.EmployeeRepository;

@Service
public class EmployeeService {

	//  Field Injection
	@Autowired
	EmployeeRepository empRepo;
	

//  Constructor Injection
//public EmployeeService(EmployeeRepository empRepo) {
//		super();
//		this.empRepo = empRepo;
//	}

//  Setter Injection
//	@Autowired
//	public void setEmpRepo(EmployeeRepository empRepo) {
//		this.empRepo = empRepo;
//	}
	
}