package com.Project.demo.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.server.ResponseStatusException;

import com.Project.demo.Constants;
import com.Project.demo.Service.EmployeeService;
import com.Project.demo.dto.EmployeeDto;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

	@Autowired
	private EmployeeService service;

	private Logger logger = LogManager.getLogger(EmployeeController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<EmployeeDto> EmployeeView(@RequestHeader(Constants.loggedInUserEmail) String useremail) {
		logger.debug("Inside EmployeeView");
		checkemail(useremail);
		List<EmployeeDto> listEmployee = service.getEmployeelistAll();
		logger.debug("Exiting EmployeeView");
		return listEmployee;
		// return "index.html";

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeRequest) {
		service.save(employeeRequest);
		logger.debug("After Saving Employee");
		return employeeRequest;
		// return "redirect:/";
	}

	@DeleteMapping()
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteEmployee(@RequestHeader("logged-in-user") String useremail) {
		logger.debug("Inside deleteEmployee");
		checkemail(useremail);
		service.delete(useremail);
		logger.debug("Deleted Employee");
		return "redirect:/";
	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String editEmployee(@RequestBody EmployeeDto employeeRequest, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
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
	public void addTechology(@RequestParam(name = "name") String techName, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		service.addTech(techName, useremail);
	}

	@PostMapping(value = "/login")
	@ResponseStatus(code = HttpStatus.OK)
	public EmployeeDto loginUser(@RequestBody EmployeeDto employeeRequest) {
		if (service.authenticate(employeeRequest)) {
			return employeeRequest;
		} else
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		// return "Wrong Credentials";
	}

	@GetMapping(value = "/details")
	@ResponseStatus(code = HttpStatus.OK)
	public EmployeeDto getEmployeeDetails(@RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		return service.getEmployeeDetails(useremail);
	}

	@DeleteMapping(value = "/removeTechnology")
	@ResponseStatus(code = HttpStatus.OK)
	public void removeTechnology(@RequestHeader(Constants.loggedInUserEmail) String useremail, @RequestParam(name = "name") String technolgyName) {
		checkemail(useremail);
		service.removeTech(technolgyName, useremail);
	}

	@GetMapping(value = "/details/{firstName}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<EmployeeDto> getEmployeesByFirstName(@RequestHeader(Constants.loggedInUserEmail) String useremail, String name) {
		return service.getEmployeesByFirstName(useremail, name);
	}
}
