package com.Project.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.TechnologyToProject;
import com.Project.demo.model.TechnologyToProjectPK;

@Repository
public interface TechnologyToProjectRepo extends JpaRepository<TechnologyToProject, TechnologyToProjectPK> {

}
