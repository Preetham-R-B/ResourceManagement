package com.Project.demo.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Project.demo.dao.EmployeeRepo;
import com.Project.demo.dao.TechnologyRepo;
import com.Project.demo.dto.TechnologyDto;
import com.Project.demo.model.Technology;

@Service
public class TechnologyService extends BaseService {

	@Autowired
	private TechnologyRepo repo;

	@Autowired
	private EmployeeRepo empRepo;

	private Logger logger = LogManager.getLogger(TechnologyService.class);

	@Transactional(readOnly = true)
	public List<TechnologyDto> TechnologylistAll() {
		// LogManager.getLogger("Inside Findall");
		List<Technology> techList = repo.findAll();
		List<TechnologyDto> returnList = null;
		for (Technology technology : techList) {
			returnList.add(new TechnologyDto(technology.getTechnologyId(), technology.getTechnologyName()));
		}
		return returnList;
	}

	@Transactional(rollbackFor = SQLException.class, readOnly = false)
	public void createTechnology(String tech, String useremail) {
		if (checkIfManager(useremail)) {
			LogManager.getLogger("Inside Save");
			Technology technology = new Technology(tech);
			repo.save(technology);
		} else {
			logger.error("User not Authorised", tech, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	// @Transactional(readOnly = true)
	// public Technology get(long id) {
	// // LogManager.getLogger("Inside FindById");
	// return repo.findById(id).get();
	// }

	@Transactional(rollbackFor = SQLException.class, readOnly = false)
	public void delete(String tech, String useremail) {
		if (checkIfManager(useremail)) {
			// LogManager.getLogger("Inside Delete");
			Technology technology = repo.findBytechnologyName(tech);
			if (Objects.nonNull(technology)) {
				// LogManager.getLogger("After Delete");
				repo.delete(technology);
			}
		} else {
			logger.error("User not Authorised", tech, useremail);
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}

	@Transactional(readOnly = true)
	public List<TechnologyDto> findByName(String tech) {
		List<Technology> techlist = repo.findByTechnologyName(tech);
		List<TechnologyDto> finalList = null;
		for (Technology t : techlist) {
			finalList.add(new TechnologyDto(t.getTechnologyId(), t.getTechnologyName()));
		}
		return finalList;

	}

}
