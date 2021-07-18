package com.Prpject.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prpject.demo.dao.EmployeeRepo;
import com.Prpject.demo.model.Employee;



@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepo repo;
	
	  public List<Employee> listAll() { 
		  return repo.findAll(); 
	  }
		  
		    public void save(Employee std) {
		        repo.save(std);
		    }
		     
		    public Employee get(long id) {
		        return repo.findById(id).get();
		    }
		     
		    public void delete(long id) {
		        repo.deleteById(id);
		    }

		
		  
	  }


