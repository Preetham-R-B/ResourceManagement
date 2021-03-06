package com.Project.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TECHNOLOGY")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Technology implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TECHNOLOGY_ID", updatable = false, nullable = false)
	private Long technologyId;

	@Column(name = "TECHNOLOGY_NAME", unique = true)
	private String technologyName;

	@JsonIgnore
	@OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
	List<EmployeeToTechnology> employees;

	@JsonIgnore
	@OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
	List<TechnologyToProject> projects;

	public List<TechnologyToProject> getProjects() {
		return projects;
	}

	public void setProjects(List<TechnologyToProject> projects) {
		this.projects = projects;
	}

	public List<EmployeeToTechnology> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeToTechnology> employees) {
		this.employees = employees;
	}

	public Technology() {
	}

	public Technology(String tech) {
		this.technologyName = tech;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

}
