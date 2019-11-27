package com.tutorial.spring.springboot.ppmtool.services;

import com.tutorial.spring.springboot.ppmtool.domain.Project;
import com.tutorial.spring.springboot.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdateProject(Project project) {
		//Logic here 
		return projectRepository.save(project);
	}
}
