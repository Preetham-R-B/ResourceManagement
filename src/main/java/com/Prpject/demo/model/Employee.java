package com.Prpject.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Employee {
	
	@Id
	@Column(name="EMPLOYEE_ID")
	 private int  EMPLOYEE_ID;
	
	@Column(name="EMPLOYEE_FIRST_NAME")
	    private String  EMPLOYEE_FIRST_NAME ;
	
	@Column(name="EMPLOYEE_LAST_NAME")
	    private String  EMPLOYEE_LAST_NAME;
	
	@Column(name="EMPLOYEE_PHONE_NUMBER")
	    private int EMPLOYEE_PHONE_NUMBER;
	
	@Column(name="EMPLOYEE_EMAIL")
	    private String EMPLOYEE_EMAIL;
	
	@Column(name="EMPLOYEE_DESIGNATION")
	    private String  EMPLOYEE_DESIGNATION;
	
	@Column(name="IS_MANAGER")
	    private boolean IS_MANAGER;
	    public Employee(){
	    	
	    	
	    }
		public Employee(int EMPLOYEE_ID, String EMPLOYEE_FIRST_NAME, String EMPLOYEE_LAST_NAME,
				int EMPLOYEE_PHONE_NUMBER, String EMPLOYEE_EMAIL, String EMPLOYEE_DESIGNATION, boolean IS_MANAGER) {
			super();
			this.EMPLOYEE_ID = EMPLOYEE_ID;
			this.EMPLOYEE_FIRST_NAME = EMPLOYEE_FIRST_NAME;
			this.EMPLOYEE_LAST_NAME = EMPLOYEE_LAST_NAME;
			this.EMPLOYEE_PHONE_NUMBER = EMPLOYEE_PHONE_NUMBER;
			this.EMPLOYEE_EMAIL = EMPLOYEE_EMAIL;
			this.EMPLOYEE_DESIGNATION = EMPLOYEE_DESIGNATION;
			this.IS_MANAGER = IS_MANAGER;
		}
		public int getEMPLOYEE_ID() {
			return EMPLOYEE_ID;
		}
		public void setEMPLOYEE_ID(int eMPLOYEE_ID) {
			EMPLOYEE_ID = eMPLOYEE_ID;
		}
		public String getEMPLOYEE_FIRST_NAME() {
			return EMPLOYEE_FIRST_NAME;
		}
		public void setEMPLOYEE_FIRST_NAME(String eMPLOYEE_FIRST_NAME) {
			EMPLOYEE_FIRST_NAME = eMPLOYEE_FIRST_NAME;
		}
		public String getEMPLOYEE_LAST_NAME() {
			return EMPLOYEE_LAST_NAME;
		}
		public void setEMPLOYEE_LAST_NAME(String eMPLOYEE_LAST_NAME) {
			EMPLOYEE_LAST_NAME = eMPLOYEE_LAST_NAME;
		}
		public int getEMPLOYEE_PHONE_NUMBER() {
			return EMPLOYEE_PHONE_NUMBER;
		}
		public void setEMPLOYEE_PHONE_NUMBER(int eMPLOYEE_PHONE_NUMBER) {
			EMPLOYEE_PHONE_NUMBER = eMPLOYEE_PHONE_NUMBER;
		}
		public String getEMPLOYEE_EMAIL() {
			return EMPLOYEE_EMAIL;
		}
		public void setEMPLOYEE_EMAIL(String eMPLOYEE_EMAIL) {
			EMPLOYEE_EMAIL = eMPLOYEE_EMAIL;
		}
		public String getEMPLOYEE_DESIGNATION() {
			return EMPLOYEE_DESIGNATION;
		}
		public void setEMPLOYEE_DESIGNATION(String eMPLOYEE_DESIGNATION) {
			EMPLOYEE_DESIGNATION = eMPLOYEE_DESIGNATION;
		}
		public boolean isIS_MANAGER() {
			return IS_MANAGER;
		}
		public void setIS_MANAGER(boolean iS_MANAGER) {
			IS_MANAGER = iS_MANAGER;
		}
	

}
