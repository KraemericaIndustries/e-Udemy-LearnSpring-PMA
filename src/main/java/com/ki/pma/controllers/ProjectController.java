package com.ki.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ki.pma.dao.ProjectRepository;
import com.ki.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		model.addAttribute("project", aProject);
		
		return "projects/new-project.html";
	}
	
	@PostMapping("/save")
	public String createProjectForm(Project project, Model model) {
		
		proRepo.save(project);
		
		//  Use a redirect when saving to the DB to prevent duplicate submissions
		return "redirect:/projects/new";
	}
}