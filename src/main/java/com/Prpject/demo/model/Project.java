package com.Prpject.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project {
	
	@Id
	@Column(name="PROJECT_ID")
	private int ProjectId;
	
	@Column(name="PROJECT_NAME")
	private String ProjectName;
	
	@Column(name="PROJECT_DESCRIPTION")
	private String ProjectDescription;
	
	@Column(name="PROJECT_START_DATE")
	private String ProjectStartDate;

	@Column(name="PROJECT_END_DATE")
	private String ProjectEndDate;
	
	@Column(name="EMPLOYEE_COUNT")
	private int EmployeeCount;
	public Project() {
		
	
	}
	public int getProjectId() {
		return ProjectId;
	}
	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getProjectDescription() {
		return ProjectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}
	public String getProjectStartDate() {
		return ProjectStartDate;
	}
	public void setProjectStartDate(String projectStartDate) {
		ProjectStartDate = projectStartDate;
	}
	public String getProjectEndDate() {
		return ProjectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		ProjectEndDate = projectEndDate;
	}
	public int getEmployeeCount() {
		return EmployeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		EmployeeCount = employeeCount;
	}


}
