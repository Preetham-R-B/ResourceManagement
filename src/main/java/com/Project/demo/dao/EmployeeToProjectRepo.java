package com.Project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.EmployeeToProject;
import com.Project.demo.model.EmployeeToProjectPK;

@Repository
public interface EmployeeToProjectRepo extends JpaRepository<EmployeeToProject, EmployeeToProjectPK> {

}
