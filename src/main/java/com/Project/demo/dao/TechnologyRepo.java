package com.Project.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Project.demo.model.Technology;


@Repository
public interface TechnologyRepo extends JpaRepository<Technology,Long> {

	Technology findBytechnologyName(String tech);

	@Query(value = "select t from Technology t where t.technologyName like %:tech%")
	List<Technology> findByTechnologyName(String tech);

	/* public void deleteByTechnologyName(String tech); */
}
