package com.Prpject.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TECHNOLOGY")
public class EmployeeToTechnology {

	@EmbeddedId
	EmployeeToTechnologyPk employeeToTechnologyPk;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("employeeId")
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("technologyId")
	@JoinColumn(name = "TECHNOLOGY_ID", referencedColumnName = "TECHNOLOGY_ID")
	private Technology technology;

	public EmployeeToTechnologyPk getEmployeeToTechnologyPk() {
		return employeeToTechnologyPk;
	}

	public void setEmployeeToTechnologyPk(EmployeeToTechnologyPk employeeToTechnologyPk) {
		this.employeeToTechnologyPk = employeeToTechnologyPk;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public EmployeeToTechnology() {
	}

}
