package com.Prpject.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Prpject.demo.Constants;
import com.Prpject.demo.dao.EmployeeRepo;

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
