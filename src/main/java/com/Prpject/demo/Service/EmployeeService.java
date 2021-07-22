package com.Prpject.demo.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.Project.demo.dto.EmployeeDto;
import com.Prpject.demo.Constants;
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

	public List<EmployeeDto> getEmployeelistAll() {
		LogManager.getLogger("Inside Findall");
		List<Employee> employees = repo.findAll();
		List<EmployeeDto> returnList = null;
		for (Employee emp : employees) {
			returnList.add(assingEmployeetoDto(emp));
		}
		return returnList;
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void save(EmployeeDto employeeRequest) {
		logger.debug("Inside employee save");
		// TODO: need to hash and salt password
		try {
			Employee registerNewEmployee = new Employee();
			registerNewEmployee.setEmployeeFirstName(employeeRequest.getFirstName());
			registerNewEmployee.setEmployeeLastName(employeeRequest.getLastName());
			registerNewEmployee.setEmployeeEmail(employeeRequest.getEmail());
			registerNewEmployee.setEmployeePhoneNumber(employeeRequest.getPhoneNumber());
			if (employeeRequest.isManager()) {
				registerNewEmployee.setEmployeeDesignation(Constants.managerRole);
				registerNewEmployee.setManager(true);
			} else {
				registerNewEmployee.setEmployeeDesignation(employeeRequest.getDesgination());
				registerNewEmployee.setManager(employeeRequest.isManager());
			}
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
	public void edit(EmployeeDto employeeRequest) {
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

	private boolean validatePassword(EmployeeDto employeeRequest, Employee employee) {
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
		EmployeeToTechnologyPk epk = new EmployeeToTechnologyPk(emp.getEmployeeId(), technology.getTechnologyId());
		et.setEmployeeToTechnologyPk(epk);
		et.setEmployee(emp);
		et.setTechnology(technology);
		etRepo.save(et);
	}

	@Transactional(readOnly = true)
	public boolean authenticate(EmployeeDto employeeRequest) {
		Employee emp = repo.findByemployeeEmail(employeeRequest.getEmail());
		if (Objects.isNull(emp))
			return false;
		if (!employeeRequest.getPassword().equals(emp.getPassword()))
			return false;
		return true;
	}

	@Transactional(readOnly = true)
	public EmployeeDto getEmployeeDetails(String useremail) {
		Employee emp = repo.findByemployeeEmail(useremail);
		return assingEmployeetoDto(emp);
	}

	@Transactional(readOnly = false, rollbackFor = SQLException.class)
	public void removeTech(String techName, String useremail) {
		Employee emp = repo.findByemployeeEmail(useremail);
		emp.getTechnologies().forEach(x -> {
			if (x.getTechnology().getTechnologyName().equals(techName)) {
				etRepo.deleteById(new EmployeeToTechnologyPk(emp.getEmployeeId(), x.getTechnology().getTechnologyId()));
			}
		});
	}

	public EmployeeDto assingEmployeetoDto(Employee emp) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setEmployeeId(emp.getEmployeeId());
		employeeDto.setFirstName(emp.getEmployeeFirstName());
		employeeDto.setLastName(emp.getEmployeeLastName());
		employeeDto.setDesgination(emp.getEmployeeDesignation());
		employeeDto.setEmail(emp.getEmployeeEmail());
		employeeDto.setManager(emp.isManager());
		employeeDto.setPhoneNumber(emp.getEmployeePhoneNumber());
		List<String> technologies = emp.getTechnologies().stream().map(x -> x.getTechnology().getTechnologyName()).collect(Collectors.toList());
		employeeDto.setTechnologies(technologies);
		return employeeDto;
	}
}
