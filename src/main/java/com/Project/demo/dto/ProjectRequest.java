package com.Project.demo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private long projectId;
	private String projectName;
	private String ProjectDescription;
	private Date ProjectStartDate;
	private Date ProjectEndDate;
	private Long EmployeeCount;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return ProjectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		ProjectDescription = projectDescription;
	}

	public Date getProjectStartDate() {
		return ProjectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		ProjectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return ProjectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		ProjectEndDate = projectEndDate;
	}

	public Long getEmployeeCount() {
		return EmployeeCount;
	}

	public void setEmployeeCount(Long employeeCount) {
		EmployeeCount = employeeCount;
	}

}
