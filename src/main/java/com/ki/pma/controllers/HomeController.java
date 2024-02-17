package com.ki.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ki.pma.dao.EmployeeRepository;
import com.ki.pma.dao.ProjectRepository;
import com.ki.pma.dto.ChartData;
import com.ki.pma.dto.EmployeeProject;
import com.ki.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

//		Map<String, Object> map = new HashMap<>();
		
		//  Query the database for projects
		List<Project> projects =  proRepo.findAll();
		model.addAttribute("projectsList", projects);

		List<ChartData> projectData = proRepo.getProjectStatus();
		
		//  Let's convert projectData object into a json structure for use in Javascript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(projectData);
		//  [["NOTSTARTED", 1], ["INPROGRESS", 2], ["COMPLETED", 1]]
		
		model.addAttribute("projectStatusCnt", jsonString);
		
		//  Query the database for employees		
		List<EmployeeProject> employeesProjectCnt =  empRepo.employeeProjects();
		model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
		
		return "main/home";
	}
}