package com.Project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.EmployeeToTechnology;
import com.Project.demo.model.EmployeeToTechnologyPk;

@Repository
public interface EmployeeToTechnologyRepo extends JpaRepository<EmployeeToTechnology, EmployeeToTechnologyPk>{

}
