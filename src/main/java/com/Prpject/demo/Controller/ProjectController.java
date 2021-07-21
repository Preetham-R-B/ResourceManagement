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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Project.demo.dto.ProjectRequest;
import com.Prpject.demo.Constants;
import com.Prpject.demo.Service.ProjectService;
import com.Prpject.demo.model.Project;

@RestController()
@RequestMapping("/project")
public class ProjectController extends BaseController {

	@Autowired
	private ProjectService service;

	private Logger logger = LogManager.getLogger(ProjectController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Project> ProjectView(@RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		logger.debug("Inside ProjectView");
		List<Project> listProject = service.ProjectlistAll(useremail);
		logger.debug("Exiting ProjectView");
		return listProject;
//		return "index.html";

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveProject(@RequestBody ProjectRequest projectRequest, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		service.createProject(projectRequest, useremail);
		logger.debug("After projectid");
		return "Created";
//		return "redirect:/";
	}

	@DeleteMapping(value = "/{projectid}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteProject(@PathVariable("projectid") Long projectid, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		logger.debug("Inside deleteproject");
		service.delete(projectid, useremail);
		logger.debug("Deleted project");
		return "redirect:/";
	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String editProject(@RequestBody ProjectRequest projectRequest, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		service.edit(projectRequest, useremail);
		return "redirect:/";
	}

}
