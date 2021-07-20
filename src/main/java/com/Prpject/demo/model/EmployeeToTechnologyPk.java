package com.Prpject.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Embeddable
public class EmployeeToTechnologyPk implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long employeeId;
	private Long technologyIdLong;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getTechnologyIdLong() {
		return technologyIdLong;
	}

	public void setTechnologyIdLong(Long technologyIdLong) {
		this.technologyIdLong = technologyIdLong;
	}

//	@ManyToOne(fetch = FetchType.LAZY/*, targetEntity = Employee.class*/)
//	@JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
////	@Column(name = "EMPLOYEE_ID")
//	private Employee employee;
//
//	@ManyToMany(fetch = FetchType.LAZY/*, targetEntity = Technology.class*/)
//	@JoinColumn(name = "TECHNOLOGY_ID", referencedColumnName = "TECHNOLOGY_ID")
//	private Technology technology;
//
//	public Employee getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
//
//	public Technology getTechnology() {
//		return technology;
//	}
//
//	public void setTechnology(Technology technology) {
//		this.technology = technology;
//	}
}
