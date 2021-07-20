package com.Prpject.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROJECT")
public class Project implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PROJECT_ID")
	private int ProjectId;
	
	@Column(name="PROJECT_NAME")
	private String ProjectName;
	
	@Column(name="PROJECT_DESCRIPTION")
	private String ProjectDescription;
	
	@Temporal(TemporalType.DATE)
	@Column(name="PROJECT_START_DATE")
	private Date ProjectStartDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="PROJECT_END_DATE")
	private Date ProjectEndDate;
	
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
	public int getEmployeeCount() {
		return EmployeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		EmployeeCount = employeeCount;
	}


}
