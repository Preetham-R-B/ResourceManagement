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
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID", updatable = false, nullable = false)
	private Long employeeId;

	@Column(name = "EMPLOYEE_FIRST_NAME")
	private String employeeFirstName;

	@Column(name = "EMPLOYEE_LAST_NAME")
	private String employeeLastName;

	@Column(name = "EMPLOYEE_PHONE_NUMBER")
	private Long employeePhoneNumber;

	@Column(name = "EMPLOYEE_EMAIL", unique = true)
	private String employeeEmail;

	@Column(name = "EMPLOYEE_DESIGNATION")
	private String employeeDesignation;

	@Column(name = "IS_MANAGER")
	private boolean isManager;

	@Column(name = "PASSWORD")
	private String password;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<EmployeeToTechnology> technologies;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public long getEmployeePhoneNumber() {
		return employeePhoneNumber;
	}

	public void setEmployeePhoneNumber(long employeePhoneNumber) {
		this.employeePhoneNumber = employeePhoneNumber;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

}
