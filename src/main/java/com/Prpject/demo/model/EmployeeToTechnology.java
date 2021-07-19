package com.Prpject.demo.model;

import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TECHNOLOGY")
public class EmployeeToTechnology {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
	private Employee employee;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TECHNOLOGY_ID", referencedColumnName = "TECHNOLOGY_ID")
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
	

}
