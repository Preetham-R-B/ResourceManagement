package com.Prpject.demo.Service;

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

import com.Project.demo.dto.EmployeeRequest;
import com.Prpject.demo.dao.EmployeeRepo;
import com.Prpject.demo.dao.EmployeeToTechnologyRepo;
import com.Prpject.demo.dao.TechnologyRepo;
import com.Prpject.demo.model.Employee;
import com.Prpject.demo.model.EmployeeToTechnology;
import com.Prpject.demo.model.EmployeeToTechnologyPk;
import com.Prpject.demo.model.Technology;

@Service
public class EmployeeService extends BaseService {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private TechnologyRepo techRepo;

	@Autowired
	private EmployeeToTechnologyRepo etRepo;

	private Logger logger = LogManager.getLogger(EmployeeService.class);

	public List<Employee> EmployeelistAll() {
		LogManager.getLogger("Inside Findall");
		return repo.findAll();
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void save(EmployeeRequest employeeRequest) {
		logger.debug("Inside employee save");
		// TODO: need to hash and salt password
		try {
			Employee registerNewEmployee = new Employee();
			registerNewEmployee.setEmployeeFirstName(employeeRequest.getFirstName());
			registerNewEmployee.setEmployeeLastName(employeeRequest.getLastName());
			registerNewEmployee.setEmployeeEmail(employeeRequest.getEmail());
			registerNewEmployee.setEmployeePhoneNumber(employeeRequest.getPhoneNumber());
			registerNewEmployee.setEmployeeDesignation(employeeRequest.getDesgination());
			registerNewEmployee.setManager(employeeRequest.isManager());
			registerNewEmployee.setPassword(employeeRequest.getPassword());
			repo.save(registerNewEmployee);
		} catch (Exception e) {
			logger.error("Error", employeeRequest, e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}

	@Transactional(readOnly = true)
	public Employee get(long id) {
		LogManager.getLogger("Inside FindById");
		return repo.findById(id).get();
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void delete(String employeeEmail) {
		LogManager.getLogger("Inside Delete");
		Employee employee = repo.findByemployeeEmail(employeeEmail);
		if (Objects.nonNull(employee)) {

			LogManager.getLogger("After Delete");
			repo.delete(employee);
		}

	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void edit(EmployeeRequest employeeRequest) {
		LogManager.getLogger("Inside edit");
		Employee employee = repo.findByemployeeEmail(employeeRequest.getEmail());
		if (Objects.nonNull(employee)) {
			// TODO : need to check password from db salt
			if (employee.getEmployeeEmail().equals(employeeRequest.getEmail()) && validatePassword(employeeRequest, employee)) {
				employee.setEmployeeFirstName(employeeRequest.getFirstName());
				employee.setEmployeeLastName(employeeRequest.getLastName());
				employee.setEmployeePhoneNumber(employeeRequest.getPhoneNumber());
				employee.setPassword(employeeRequest.getNewPassowrd());
				LogManager.getLogger("After edit");
				repo.save(employee);
			} else {
				logger.error("Invalid User", employeeRequest);
			}
		}

	}

	private boolean validatePassword(EmployeeRequest employeeRequest, Employee employee) {
		try {
			if (employeeRequest.getOldPassword().equals(employeeRequest.getNewPassowrd()))
				return false;
			if (!employeeRequest.getOldPassword().equals(employee.getPassword()))
				return false;
			if (Objects.isNull(employeeRequest.getNewPassowrd()))
				return false;
			if (employeeRequest.getNewPassowrd().length() < 5)
				return false;
			return true;
		} catch (Exception e) {
			logger.error("Error", employeeRequest, employee, e.getMessage());
			return false;
		}
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void addTech(String techName, String useremail) {
		Technology technology = techRepo.findBytechnologyName(techName);
		Employee emp = repo.findByemployeeEmail(useremail);
		EmployeeToTechnology et = new EmployeeToTechnology();
		EmployeeToTechnologyPk etpk = new EmployeeToTechnologyPk(emp.getEmployeeId(), technology.getTechnologyId());
		et.setEmployeeToTechnologypk(etpk);
		et.setEmployee(emp);
		et.setTechnology(technology);
		etRepo.save(et);
	}

	public boolean authenticate(EmployeeRequest employeeRequest) {
		Employee emp = repo.findByemployeeEmail(employeeRequest.getEmail());
		if (Objects.isNull(emp))
			return false;
		if (!employeeRequest.getPassword().equals(emp.getPassword()))
			return false;
		return true;
	}
}
