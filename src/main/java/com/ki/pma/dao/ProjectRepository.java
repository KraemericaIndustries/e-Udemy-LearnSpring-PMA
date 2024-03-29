package com.ki.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ki.pma.dto.ChartData;
import com.ki.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	@Override
	public List<Project> findAll();
	
	@Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as item "
									 + "FROM project "
									 + "GROUP BY stage")
	public List<ChartData> getProjectStatus();
}