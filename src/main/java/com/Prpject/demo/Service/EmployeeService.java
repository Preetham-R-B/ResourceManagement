package com.Prpject.demo.Service;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void save(Employee std) {
		LogManager.getLogger("Inside save");
		repo.save(std);
	}

	public Employee get(long id) {
		LogManager.getLogger("Inside FindById");
		return repo.findById(id).get();
	}

	public void delete(String employeeEmail) {
		LogManager.getLogger("Inside Delete");
		Employee employee = repo.findByEmail(employeeEmail);
		if (Objects.nonNull(employee)) {

			LogManager.getLogger("After Delete");
			repo.delete(employee);
		}

	}

	public void edit(String employeeEmail) {
		LogManager.getLogger("Inside edit");
		Employee employee = repo.findByEmail(employeeEmail);
		if (Objects.nonNull(employee)) {

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
