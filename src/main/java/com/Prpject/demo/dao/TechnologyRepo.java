package com.Prpject.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Prpject.demo.model.Technology;


@Repository
public interface TechnologyRepo extends JpaRepository<Technology,Long> {

	Technology findBytechnologyName(String tech);

	@Query(value = "select t from Technology t where t.technologyName like %:tech%")
	List<Technology> findByTechnologyName(String tech);

	/* public void deleteByTechnologyName(String tech); */
}
