package com.Prpject.demo.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Project.demo.dto.EmployeeRequest;
import com.Prpject.demo.Service.EmployeeService;
import com.Prpject.demo.model.Employee;

@RestController(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	private Logger logger = LogManager.getLogger(EmployeeController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> EmployeeView() {
		logger.debug("Inside EmployeeView");
		List<Employee> listEmployee = service.EmployeelistAll();
		logger.debug("Exiting EmployeeView");
		return listEmployee;
//		return "index.html";

	}

	@PostMapping(value = "/{employeeEmail}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		service.save(employeeRequest);
		logger.debug("After SavingEmployee");
		return "Created";
//		return "redirect:/";
	}

	@DeleteMapping(value = "/{employeeEmail}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteEmployee(@PathVariable("employeeEmail") String employeeEmail) {
		logger.debug("Inside deleteEmployee");
		service.delete(employeeEmail);
		logger.debug("Deleted Employee");
		return "redirect:/";
	}
	
	@PutMapping(value = "/{employeeEmail}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String editEmployee(@RequestBody EmployeeRequest employeeRequest) {
		service.edit(employeeRequest);
		return "redirect:/";
	}
}
