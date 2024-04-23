package com.ki.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ki.pma.dao.ProjectRepository;
import com.ki.pma.dto.ChartData;
import com.ki.pma.entities.Project;

@Service
public class ProjectService {
	
	@Autowired 
	ProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus() {
		return proRepo.getProjectStatus();
	}
}