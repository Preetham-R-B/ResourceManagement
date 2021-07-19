package com.Prpject.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Prpject.demo.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project,Long>{

}