package com.Prpject.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Prpject.demo.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long>{

	@Query(value = "select p from Project p where p.employee.employeeEmail=:useremail")
	List<Project> findByEmail(String useremail);

}
