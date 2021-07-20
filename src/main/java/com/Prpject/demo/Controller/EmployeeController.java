package com.Prpject.demo.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Project.demo.dto.EmployeeRequest;
import com.Prpject.demo.Service.EmployeeService;
import com.Prpject.demo.model.Employee;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	private Logger logger = LogManager.getLogger(EmployeeController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Employee> EmployeeView(@RequestHeader("logged-in-user") String useremail) {
		logger.debug("Inside EmployeeView");
		List<Employee> listEmployee = service.EmployeelistAll();
		logger.debug("Exiting EmployeeView");
		return listEmployee;
		// return "index.html";

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		service.save(employeeRequest);
		logger.debug("After Saving Employee");
		return "Created";
		// return "redirect:/";
	}

	@DeleteMapping()
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteEmployee(@RequestHeader("logged-in-user") String useremail) {
		logger.debug("Inside deleteEmployee");
		service.delete(useremail);
		logger.debug("Deleted Employee");
		return "redirect:/";
	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String editEmployee(@RequestBody EmployeeRequest employeeRequest, @RequestHeader("logged-in-user") String useremail) {
		if (useremail.equals(employeeRequest.getEmail())) {
			service.edit(employeeRequest);
			return "Sucess";
		} else {
			return "Failure";
		}
		// return "redirect:/";
	}

	@PostMapping(value = "/addTechnology")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addTechology(@RequestParam(name = "name") String techName, @RequestHeader("logged-in-user") String useremail) {
		service.addTech(techName, useremail);
	}

	@GetMapping(value = "/login")
	@ResponseStatus(code = HttpStatus.OK)
	public String loginUser(@RequestBody EmployeeRequest employeeRequest) {
		if (service.authenticate(employeeRequest)) {
			return employeeRequest.getEmail();
		}
		else
			return "Wrong Credentials";
	}
}
