package com.Prpject.demo.model;

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

@Entity
@Table(name = "TECHNOLOGY")
public class Technology implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TECHNOLOGY_ID", updatable = false, nullable = false)
	private Long technologyId;

	@Column(name = "TECHNOLOGY_NAME", unique = true)
	private String technologyName;

	@OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
	List<EmployeeToTechnology> employees;

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
