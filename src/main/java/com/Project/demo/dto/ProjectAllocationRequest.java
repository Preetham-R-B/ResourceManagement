package com.Project.demo.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectAllocationRequest implements Serializable{

	private long projectId;
	private long employeeId;
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
}
