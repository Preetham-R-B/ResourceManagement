package com.Prpject.demo.Service;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.demo.dto.EmployeeRequest;
import com.Prpject.demo.dao.EmployeeRepo;
import com.Prpject.demo.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	private Logger logger = LogManager.getLogger(EmployeeService.class);

	public List<Employee> EmployeelistAll() {
		LogManager.getLogger("Inside Findall");
		return repo.findAll();
	}

	public void save(EmployeeRequest employeeRequest) {
		LogManager.getLogger("Inside save");
		Employee registerNewEmployee = new Employee();
		registerNewEmployee.setEmployeeFirstName(employeeRequest.getFirstName());
		registerNewEmployee.setEmployeeLastName(employeeRequest.getLastName());
		registerNewEmployee.setEmployeeEmail(employeeRequest.getEmail());
		registerNewEmployee.setEmployeePhoneNumber(employeeRequest.getPhoneNumber());
		registerNewEmployee.setEmployeeDesignation(employeeRequest.getDesgination());
		registerNewEmployee.setManager(employeeRequest.isManager());
		repo.save(registerNewEmployee);
	}

	public Employee get(long id) {
		LogManager.getLogger("Inside FindById");
		return repo.findById(id).get();
	}

	public void delete(String employeeEmail) {
		LogManager.getLogger("Inside Delete");
		Employee employee = repo.findByemployeeEmail(employeeEmail);
		if (Objects.nonNull(employee)) {

			LogManager.getLogger("After Delete");
			repo.delete(employee);
		}

	}

	public void edit(EmployeeRequest employeeRequest) {
		LogManager.getLogger("Inside edit");
		Employee employee = repo.findByemployeeEmail(employeeRequest.getEmail());
		if (Objects.nonNull(employee)) {
			//TODO : need to check password from db 
			employee.setEmployeeFirstName(employeeRequest.getFirstName());
			employee.setEmployeeLastName(employeeRequest.getLastName());
			employee.setEmployeePhoneNumber(employeeRequest.getPhoneNumber());
			LogManager.getLogger("After edit");
			repo.save(employee);
		}

	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
