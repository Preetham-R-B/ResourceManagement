package com.Project.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmployeeToTechnologyPk implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@Column(name = "TECHNOLOGY_ID")
	private Long technologyId;

	public EmployeeToTechnologyPk() {
	}

	public EmployeeToTechnologyPk(Long employeeId, Long technologyId) {
		this.employeeId = employeeId;
		this.technologyId = technologyId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getTechnologyId() {
		return technologyId;
	}

	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((technologyId == null) ? 0 : technologyId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeToTechnologyPk other = (EmployeeToTechnologyPk) obj;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (technologyId == null) {
			if (other.technologyId != null)
				return false;
		} else if (!technologyId.equals(other.technologyId))
			return false;
		return true;
	}

}
