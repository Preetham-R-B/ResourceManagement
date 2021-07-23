package com.Project.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_ID")
	private int projectId;

	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Column(name = "PROJECT_DESCRIPTION")
	private String projectDescription;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROJECT_START_DATE")
	private Date projectStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROJECT_END_DATE")
	private Date projectEndDate;

	@Column(name = "EMPLOYEE_COUNT")
	private Long employeeCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", referencedColumnName = "EMPLOYEE_ID", updatable = false)
	private Employee employee;

	// @JsonIgnore
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	List<TechnologyToProject> technologies;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	List<EmployeeToProject> employees;

	public List<EmployeeToProject> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeToProject> employees) {
		this.employees = employees;
	}

	public List<TechnologyToProject> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<TechnologyToProject> technologies) {
		this.technologies = technologies;
	}

	public Project() {
	}

	public Project(String projName, String projDesc, Date sdate, Date edate, Long count, Employee emp) {
		this.employee = emp;
		this.employeeCount = count;
		this.projectEndDate = edate;
		this.projectStartDate = sdate;
		this.projectDescription = projDesc;
		this.projectName = projName;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

	public Long getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(Long employeeCount) {
		this.employeeCount = employeeCount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
