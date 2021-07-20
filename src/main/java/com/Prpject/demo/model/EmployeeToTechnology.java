package com.Prpject.demo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TECHNOLOGY")
public class EmployeeToTechnology implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeToTechnologyPk employeeToTechnologypk;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("EMPLOYEE_ID")
	private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("TECHNOLOGY_ID")
	private Technology technology;

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

	public EmployeeToTechnologyPk getEmployeeToTechnologypk() {
		return employeeToTechnologypk;
	}

	public void setEmployeeToTechnologypk(EmployeeToTechnologyPk employeeToTechnologypk) {
		this.employeeToTechnologypk = employeeToTechnologypk;
	}

}
