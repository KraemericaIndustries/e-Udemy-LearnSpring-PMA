package com.ki.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ki.pma.dao.EmployeeRepository;
import com.ki.pma.dao.ProjectRepository;
import com.ki.pma.entities.Employee;
import com.ki.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proService;
	
	@Autowired
	EmployeeRepository empService;
	
	@GetMapping
	public String displayProjects(Model model) {
		List<Project> projects = proService.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empService.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		return "projects/new-project.html";
	}
	
	@PostMapping("/save")
	public String createProjectForm(Project project, Model model) {
		
		proService.save(project);
		
		//  Use a redirect when saving to the DB to prevent duplicate submissions
		return "redirect:/projects";
	}
}