package com.Project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{ 
	
	Employee findByemployeeEmail(String employeeEmail);

	@Query(value = "select e from Employee e where e.employeeFirstName like %:name%")
	List<Employee> findByFirstName(String name);

}
