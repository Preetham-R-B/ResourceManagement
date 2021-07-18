package com.Prpject.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Prpject.demo.model.Technology;


@Repository
public interface TechnologyRepo extends JpaRepository<Technology,Long> {

	Technology findByTechnologyName(String tech);

	/* public void deleteByTechnologyName(String tech); */
}
