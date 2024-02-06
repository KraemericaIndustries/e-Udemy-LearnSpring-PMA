package com.ki.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.ki.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	
}