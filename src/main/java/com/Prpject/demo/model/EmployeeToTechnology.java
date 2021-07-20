package com.Prpject.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_TECHNOLOGY")
public class EmployeeToTechnology implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeToTechnologyPk employeeToTechnologypk;

	@OneToOne
	@MapsId("EMPLOYEE_ID")
	private Employee employee;

	@OneToOne
	@MapsId("TECHNOLOGY_ID")
	private Technology technology;

	public EmployeeToTechnologyPk getEmployeeToTechnologypk() {
		return employeeToTechnologypk;
	}

	public void setEmployeeToTechnologypk(EmployeeToTechnologyPk employeeToTechnologypk) {
		this.employeeToTechnologypk = employeeToTechnologypk;
	}

}
