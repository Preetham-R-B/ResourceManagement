package com.Project.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeToProjectPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Column(name = "PROJECT_ID")
	private Long projectId;

	public EmployeeToProjectPK() {
	}

	public EmployeeToProjectPK(Long employeeId, Long projectId) {
		this.employeeId = employeeId;
		this.projectId = projectId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
}
