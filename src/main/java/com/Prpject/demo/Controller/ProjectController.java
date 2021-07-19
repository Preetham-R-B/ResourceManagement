package com.Prpject.demo.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Project.demo.dto.EmployeeRequest;
import com.Project.demo.dto.ProjectRequest;
import com.Prpject.demo.Service.ProjectService;
import com.Prpject.demo.model.Employee;
import com.Prpject.demo.model.Project;

@RestController(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService service;

	private Logger logger = LogManager.getLogger(ProjectController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Project> ProjectView() {
		logger.debug("Inside ProjectView");
		List<Project> listProject = service.ProjectlistAll();
		logger.debug("Exiting ProjectView");
		return listProject;
//		return "index.html";

	}
	
	
	@PostMapping(value = "/{projectid}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveProject(@RequestBody ProjectRequest projectRequest) {
		service.save(projectRequest);
		logger.debug("After projectid");
		return "Created";
//		return "redirect:/";
	}

	@DeleteMapping(value = "/{projectid}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteProject(@PathVariable("projectid") Long projectid) {
		logger.debug("Inside deleteproject");
		service.delete(projectid);
		logger.debug("Deleted project");
		return "redirect:/";
	}

	@PutMapping(value = "/{employeeEmail}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String editProject(@RequestBody ProjectRequest projectRequest) {
		service.edit(projectRequest);
		return "redirect:/";
	}
	
	@PostMapping(value = "/{projectid}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void assignEmployeetoProject() {
		
		
	}

}
