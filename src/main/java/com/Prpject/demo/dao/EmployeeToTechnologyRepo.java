package com.Prpject.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Prpject.demo.model.EmployeeToTechnology;
import com.Prpject.demo.model.EmployeeToTechnologyPk;

@Repository
public interface EmployeeToTechnologyRepo extends JpaRepository<EmployeeToTechnology, EmployeeToTechnologyPk>{

}
