package com.Project.demo.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Project.demo.dao.EmployeeToProjectRepo;
import com.Project.demo.dao.ProjectRepo;
import com.Project.demo.dao.TechnologyRepo;
import com.Project.demo.dao.TechnologyToProjectRepo;
import com.Project.demo.dto.ProjectDto;
import com.Project.demo.model.EmployeeToProject;
import com.Project.demo.model.EmployeeToProjectPK;
import com.Project.demo.model.Project;
import com.Project.demo.model.Technology;
import com.Project.demo.model.TechnologyToProject;
import com.Project.demo.model.TechnologyToProjectPK;

@Service
public class ProjectService extends BaseService {

	@Autowired
	private ProjectRepo projectRepo;

	@Autowired
	private TechnologyRepo technologyRepo;

	@Autowired
	private TechnologyToProjectRepo technologyToProjectRepo;

	@Autowired
	private EmployeeToProjectRepo employeeToProjectRepo;

	private Logger logger = LogManager.getLogger(ProjectService.class);

	@Transactional(readOnly = true)
	public List<ProjectDto> ProjectlistAll(String useremail) {
		List<Project> projects = projectRepo.findByEmail(useremail);
		List<ProjectDto> returnList = projects.stream().map(x -> assignProjectToDto(x)).collect(Collectors.toList());
		return returnList;
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void createProject(ProjectDto projectRequest, String useremail) {
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
		if (checkIfManager(useremail) && checkIfProjectOwner(projectid, useremail)) {
			Project project = projectRepo.findById(projectid).get();
			if (Objects.nonNull(project)) {
				// LogManager.getLogger("After Delete");
				projectRepo.delete(project);
			}
		} else {
			logger.error("Unauthorised", projectid, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void edit(ProjectDto projectRequest, String useremail) {
		if (checkIfManager(useremail) && checkIfProjectOwner(projectRequest.getProjectId(), useremail)) {
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
			logger.error("Unauthorised", projectRequest, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = true)
	private boolean checkIfProjectOwner(Long projectId, String useremail) {
		if (projectRepo.findById(projectId).get().getEmployee().getEmployeeEmail().equals(useremail))
			return true;
		return false;
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void addTechnologyToProject(String useremail, Long projectId, String technologyName) {
		if (checkIfManager(useremail) && checkIfProjectOwner(projectId, useremail)) {
			Project project = projectRepo.findById(projectId).get();
			Technology technology = technologyRepo.findBytechnologyName(technologyName);
			technologyToProjectRepo.save(new TechnologyToProject(new TechnologyToProjectPK(projectId, technology.getTechnologyId()), project, technology));
		} else {
			logger.error("Unauthorised", useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void removeTechnologyFromProject(String useremail, Long projectId, String technologyName) {
		if (checkIfManager(useremail) && checkIfProjectOwner(projectId, useremail)) {
			Project project = projectRepo.findById(projectId).get();
			project.getTechnologies().stream().forEach(x -> {
				if (x.getTechnology().getTechnologyName().equals(technologyName)) {
					technologyToProjectRepo.deleteById(new TechnologyToProjectPK(x.getTechnology().getTechnologyId(), projectId));
				}
			});
		} else {
			logger.error("Unauthorised", useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	private ProjectDto assignProjectToDto(Project project) {
		if (Objects.nonNull(project)) {
			ProjectDto p = new ProjectDto();
			p.setCreatedBy(project.getEmployee().getEmployeeEmail());
			p.setEmployeeCount(project.getEmployeeCount());
			p.setProjectDescription(project.getProjectDescription());
			p.setProjectEndDate(project.getProjectEndDate());
			p.setProjectStartDate(project.getProjectStartDate());
			p.setProjectName(project.getProjectName());
			p.setEmployees(project.getEmployees().stream().map(x -> x.getEmployee().getEmployeeFirstName() + " " + x.getEmployee().getEmployeeLastName())
					.collect(Collectors.toList()));
			p.setTechnologies(project.getTechnologies().stream().map(x -> x.getTechnology().getTechnologyName()).collect(Collectors.toList()));
			return p;
		} else {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public ProjectDto getProjectDetailsByProjectId(String useremail, Long projectId) {
		Project project = projectRepo.findById(projectId).get();
		if (checkIfManager(useremail) && checkIfProjectOwner(projectId, useremail)) {
			return assignProjectToDto(project);
		} else {
			logger.error("Unauthorised", useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = true)
	public List<ProjectDto> getProjectDetailsByProjectName(String useremail, String projectName) {
		return projectRepo.findByEmailAndProjectName(useremail, projectName).stream().map(x -> assignProjectToDto(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void addEmployeeToProject(String useremail, Long projectId, Long empId) {
		if (checkIfManager(useremail) && checkIfProjectOwner(projectId, useremail) && checkIfAllowed(projectId)) {
			employeeToProjectRepo.save(new EmployeeToProject(new EmployeeToProjectPK(empId, projectId), projectRepo.findById(projectId).get(),
					employeeRepo.findById(empId).get()));
			Project p = projectRepo.findById(projectId).get();
			p.setEmployeeCount(p.getEmployeeCount() + 1);
			projectRepo.save(p);
		}
	}

	private boolean checkIfAllowed(Long projectId) {
		Project p = projectRepo.findById(projectId).get();
		if (p.getEmployeeCount() > 0)
			return true;
		return false;
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void removeEmployeeToProject(String useremail, Long projectId, Long empId) {
		if (checkIfManager(useremail) && checkIfProjectOwner(projectId, useremail)) {
			employeeToProjectRepo.deleteById(new EmployeeToProjectPK(empId, projectId));
		}
	}
}
