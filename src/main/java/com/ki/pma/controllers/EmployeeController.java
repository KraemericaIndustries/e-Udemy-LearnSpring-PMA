package com.ki.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ki.pma.dao.EmployeeRepository;
import com.ki.pma.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empService.findAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee.html";
	}
	
	@PostMapping("/save")
	public String createEmployee(Model model, Employee employee) {
		//  save to the database using an employee crud repository
	
		empService.save(employee);
		return "redirect:/employees/new";
	}
}