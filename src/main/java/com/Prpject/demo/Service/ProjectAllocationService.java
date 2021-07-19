package com.Prpject.demo.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prpject.demo.dao.EmployeeRepo;
import com.Prpject.demo.dao.ProjectAllocationRepo;
import com.Prpject.demo.dao.ProjectRepo;
import com.Prpject.demo.model.Employee;
import com.Prpject.demo.model.Project;
import com.Prpject.demo.model.ProjectToEmployee;

@Service
public class ProjectAllocationService {
	@Autowired
	private  ProjectAllocationRepo projectAllocationRepo;
	
	@Autowired
	private  ProjectRepo projectRepo;
	
	@Autowired
	private  EmployeeRepo employeeRepo;
	
	private Logger logger = LogManager.getLogger(ProjectService.class);

	public void save(long projectId, long employeeId) {
		ProjectToEmployee projectToEmployee = new ProjectToEmployee();
		Employee emp = employeeRepo.findById(projectId).get();
		Project proj = projectRepo.findById(projectId).get();
		projectToEmployee.setEmployee(emp);
		projectToEmployee.setProject(proj);
		projectAllocationRepo.save(projectToEmployee);
	}
	
}
