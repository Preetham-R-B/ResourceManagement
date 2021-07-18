package com.Prpject.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prpject.demo.dao.ProjectRepo;
import com.Prpject.demo.model.Project;

@Service
public class ProjectService {
	
		
		@Autowired
	    private ProjectRepo repo;
		
		  public List<Project> ProjectlistAll() { 
			  return repo.findAll(); 
		  }
		  
		  public void save(Project std) {
		        repo.save(std);
		    }
		     
		    public Project get(long id) {
		        return repo.findById(id).get();
		    }
		    
		    public void delete(long id) {
		        repo.deleteById(id);
		    }


}
