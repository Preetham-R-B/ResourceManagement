package com.Prpject.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Prpject.demo.model.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>{ 

}
