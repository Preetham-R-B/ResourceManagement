package com.Project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{ 
	
	Employee findByemployeeEmail(String employeeEmail);

}
