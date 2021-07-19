package com.Prpject.demo.Service;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prpject.demo.dao.ProjectRepo;
import com.Prpject.demo.model.Employee;
import com.Prpject.demo.model.Project;
import com.Prpject.demo.model.Technology;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo repo;

	private Logger logger = LogManager.getLogger(ProjectService.class);

	public List<Project> ProjectlistAll() {

		LogManager.getLogger("Inside Findall");
		return repo.findAll();
	}

	public void save(Project std) {
		LogManager.getLogger("Inside Findall");
		repo.save(std);
	}

	public Project get(Long id) {
		LogManager.getLogger("Inside FindById");
		return repo.findById(id).get();
	}

	public void delete(Long projectid) {
		LogManager.getLogger("Inside Delete");
		Project project = repo.findById(projectid).get();
		if (Objects.nonNull(project)) {

			LogManager.getLogger("After Delete");
			repo.delete(project);
		}
	}

}
