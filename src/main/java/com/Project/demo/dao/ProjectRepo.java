package com.Project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long>{

	@Query(value = "select p from Project p where p.employee.employeeEmail=:useremail")
	List<Project> findByEmail(@Param("useremail") String useremail);

	@Query(value = "select p from Project p where p.employee.employeeEmail=:useremail and p.projectName like %:projectName%")
	List<Project> findByEmailAndProjectName(String useremail, String projectName);

}
