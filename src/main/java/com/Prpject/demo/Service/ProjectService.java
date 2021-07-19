package com.Prpject.demo.Service;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.demo.dto.ProjectRequest;
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

	public void save(ProjectRequest projectRequest) {
		LogManager.getLogger("Inside Findall");
		//TODO : allow only manager to add and edit project
		Project createNewProject = new Project();
		createNewProject.setProjectName(projectRequest.getProjectName());
		createNewProject.setProjectDescription(projectRequest.getProjectDescription());
		createNewProject.setProjectStartDate(projectRequest.getProjectStartDate());
		createNewProject.setProjectEndDate(projectRequest.getProjectEndDate());
		createNewProject.setEmployeeCount(projectRequest.getEmployeeCount());
		repo.save(createNewProject);
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

	public void edit(ProjectRequest projectRequest) {
		//TODO : allow only manager to add and edit project
		if (Objects.nonNull(projectRequest)) {
			Project createNewProject = new Project();
			createNewProject.setProjectName(projectRequest.getProjectName());
			createNewProject.setProjectDescription(projectRequest.getProjectDescription());
			createNewProject.setProjectStartDate(projectRequest.getProjectStartDate());
			createNewProject.setProjectEndDate(projectRequest.getProjectEndDate());
			createNewProject.setEmployeeCount(projectRequest.getEmployeeCount());
			repo.save(createNewProject);
		}
	}
	
}

