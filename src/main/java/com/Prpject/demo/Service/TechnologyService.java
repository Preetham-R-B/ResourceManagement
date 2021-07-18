package com.Prpject.demo.Service;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prpject.demo.dao.TechnologyRepo;
import com.Prpject.demo.model.Technology;

@Service
public class TechnologyService {
	
	@Autowired
    private TechnologyRepo repo;
	
	private Logger logger = LogManager.getLogger(TechnologyService.class);
	
	  public List<Technology> TechnologylistAll() { 
		  
		  return repo.findAll(); 
	  }
	  
	  public void save(Technology std) {
	        repo.save(std);
	    }
	     
	    public Technology get(long id) {
	        return repo.findById(id).get();
	    }
	    
	    public void delete(String tech) {
	    	
	    	Technology technology = repo.findByTechnologyName(tech);
	    	if(Objects.nonNull(technology)) {
	    		repo.delete(technology);
	    	}
	    }

	
}
