package com.Prpject.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROJECT")
public class Project {
	
	@Id
	@Column(name="PROJECT_ID")
	private int PROJECT_ID;
	
	@Column(name="PROJECT_NAME")
	private String PROJECT_NAME;
	
	@Column(name="PROJECT_DESCRIPTION")
	private String PROJECT_DESCRIPTION;
	
	@Column(name="PROJECT_START_DATE")
	private String PROJECT_START_DATE;

	@Column(name="PROJECT_END_DATE")
	private String PROJECT_END_DATE;
	
	@Column(name="EMPLOYEE_COUNT")
	private int EMPLOYEE_COUNT;
	public Project() {
		
	
	}
	public Project(int PROJECT_ID, String PROJECT_NAME, String PROJECT_DESCRIPTION, String PROJECT_START_DATE,
			String PROJECT_END_DATE, int eMPLOYEE_COUNT) {
		super();
		this.PROJECT_ID = PROJECT_ID;
		this.PROJECT_NAME = PROJECT_NAME;
		this.PROJECT_DESCRIPTION = PROJECT_DESCRIPTION;
		this.PROJECT_START_DATE = PROJECT_START_DATE;
		this.PROJECT_END_DATE = PROJECT_END_DATE;
		this.EMPLOYEE_COUNT = eMPLOYEE_COUNT;
	}
	public int getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(int pROJECT_ID) {
		PROJECT_ID = pROJECT_ID;
	}
	public String getPROJECT_NAME() {
		return PROJECT_NAME;
	}
	public void setPROJECT_NAME(String pROJECT_NAME) {
		PROJECT_NAME = pROJECT_NAME;
	}
	public String getPROJECT_DESCRIPTION() {
		return PROJECT_DESCRIPTION;
	}
	public void setPROJECT_DESCRIPTION(String pROJECT_DESCRIPTION) {
		PROJECT_DESCRIPTION = pROJECT_DESCRIPTION;
	}
	public String getPROJECT_START_DATE() {
		return PROJECT_START_DATE;
	}
	public void setPROJECT_START_DATE(String pROJECT_START_DATE) {
		PROJECT_START_DATE = pROJECT_START_DATE;
	}
	public String getPROJECT_END_DATE() {
		return PROJECT_END_DATE;
	}
	public void setPROJECT_END_DATE(String pROJECT_END_DATE) {
		PROJECT_END_DATE = pROJECT_END_DATE;
	}
	public int getEMPLOYEE_COUNT() {
		return EMPLOYEE_COUNT;
	}
	public void setEMPLOYEE_COUNT(int eMPLOYEE_COUNT) {
		EMPLOYEE_COUNT = eMPLOYEE_COUNT;
	}

}
