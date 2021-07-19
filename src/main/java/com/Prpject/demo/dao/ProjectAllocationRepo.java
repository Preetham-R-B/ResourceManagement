package com.Prpject.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Prpject.demo.model.ProjectToEmployee;

@Repository
public interface ProjectAllocationRepo extends JpaRepository<ProjectToEmployee, Long> {

}
