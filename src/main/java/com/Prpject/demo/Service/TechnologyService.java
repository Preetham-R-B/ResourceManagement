package com.Prpject.demo.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Prpject.demo.dao.TechnologyRepo;
import com.Prpject.demo.model.Technology;

@Service
public class TechnologyService {

	@Autowired
	private TechnologyRepo repo;

	private Logger logger = LogManager.getLogger(TechnologyService.class);

//	@Transactional(readOnly = true)
	public List<Technology> TechnologylistAll() {

		LogManager.getLogger("Inside Findall");
		return repo.findAll();
	}

//	@Transactional(rollbackFor = SQLException.class, readOnly = false)
	public void save(Technology tech) {
		LogManager.getLogger("Inside Save");
		repo.save(tech);
	}

//	@Transactional(readOnly = true)
	public Technology get(long id) {

		LogManager.getLogger("Inside FindById");
		return repo.findById(id).get();
	}

//	@Transactional(rollbackFor = SQLException.class, readOnly = false)
	public void delete(String tech) {
		LogManager.getLogger("Inside Delete");
		Technology technology = repo.findBytechnologyName(tech);
		if (Objects.nonNull(technology)) {

			LogManager.getLogger("After Delete");
			repo.delete(technology);
		}
	}

	@Transactional(readOnly = true)
	public List<Technology> findByName(String tech) {
		return repo.findByTechnologyName(tech);
		
	}

}
