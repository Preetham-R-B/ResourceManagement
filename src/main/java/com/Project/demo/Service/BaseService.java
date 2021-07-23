package com.Project.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.demo.Constants;
import com.Project.demo.dao.EmployeeRepo;

@Service
public class BaseService {

	@Autowired
	EmployeeRepo employeeRepo;

	public boolean checkIfManager(String email) {
		if (employeeRepo.findByemployeeEmail(email).getEmployeeDesignation().equals(Constants.managerRole))
			return true;
		return false;
	}
}
