package com.Prpject.demo.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Project.demo.dto.ProjectRequest;
import com.Prpject.demo.dao.ProjectRepo;
import com.Prpject.demo.model.Project;

@Service
public class ProjectService extends BaseService {

	@Autowired
	private ProjectRepo projectRepo;

	private Logger logger = LogManager.getLogger(ProjectService.class);

	@Transactional(readOnly = true)
	public List<Project> ProjectlistAll(String useremail) {
		// LogManager.getLogger("Inside Findall");
		return projectRepo.findByEmail(useremail);
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void createProject(ProjectRequest projectRequest, String useremail) {
		// LogManager.getLogger("Inside Findall");
		if (checkIfManager(useremail)) {
			Project createNewProject = new Project();
			createNewProject.setProjectName(projectRequest.getProjectName());
			createNewProject.setProjectDescription(projectRequest.getProjectDescription());
			createNewProject.setProjectStartDate(projectRequest.getProjectStartDate());
			createNewProject.setProjectEndDate(projectRequest.getProjectEndDate());
			createNewProject.setEmployeeCount(projectRequest.getEmployeeCount());
			createNewProject.setEmployee(employeeRepo.findByemployeeEmail(useremail));
			projectRepo.save(createNewProject);
		} else {
			logger.error("Unauthorised", projectRequest, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = true)
	public Project get(Long id) {
		LogManager.getLogger("Inside FindById");
		return projectRepo.findById(id).get();
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void delete(Long projectid, String useremail) {
		// LogManager.getLogger("Inside Delete");
		if (checkIfManager(useremail)) {
			if (checkIfProjectOwner(projectid, useremail)) {
				Project project = projectRepo.findById(projectid).get();
				if (Objects.nonNull(project)) {
					// LogManager.getLogger("After Delete");
					projectRepo.delete(project);
				}
			} else {
				logger.error("trying to delete other project", projectid, useremail);
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
			}
		} else {
			logger.error("Unauthorised", projectid, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void edit(ProjectRequest projectRequest, String useremail) {
		if (checkIfManager(useremail)) {
			if (checkIfProjectOwner(projectRequest.getProjectId(), useremail)) {
				if (Objects.nonNull(projectRequest)) {
					Project createNewProject = new Project();
					createNewProject.setProjectName(projectRequest.getProjectName());
					createNewProject.setProjectDescription(projectRequest.getProjectDescription());
					createNewProject.setProjectStartDate(projectRequest.getProjectStartDate());
					createNewProject.setProjectEndDate(projectRequest.getProjectEndDate());
					createNewProject.setEmployeeCount(projectRequest.getEmployeeCount());
					projectRepo.save(createNewProject);
				}
			} else {
				logger.error("trying to edit other project", projectRequest, useremail);
				throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
			}
		} else {
			logger.error("Unauthorised", projectRequest, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	private boolean checkIfProjectOwner(Long projectId, String useremail) {
		if (projectRepo.findById(projectId).get().getEmployee().getEmployeeEmail().equals(useremail))
			return true;
		return false;
	}

}
