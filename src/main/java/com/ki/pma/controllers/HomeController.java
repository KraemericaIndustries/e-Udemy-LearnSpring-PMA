package com.ki.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ki.pma.dao.EmployeeRepository;
import com.ki.pma.dao.ProjectRepository;
import com.ki.pma.entities.Employee;
import com.ki.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		//  Query the database for projects
		List<Project> projects =  proRepo.findAll();
		model.addAttribute("projectsList", projects);

		//  Query the database for employees		
		List<Employee> employees =  empRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		return "main/home";
	}
}