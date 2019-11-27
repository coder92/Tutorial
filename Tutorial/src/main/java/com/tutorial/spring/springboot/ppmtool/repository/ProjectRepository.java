package com.tutorial.spring.springboot.ppmtool.repository;

import com.tutorial.spring.springboot.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	@Override
	default Iterable<Project> findAllById(Iterable<Long> ids) {
		return null;
	}
}
