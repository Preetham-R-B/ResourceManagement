package com.Project.demo.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Project.demo.Constants;
import com.Project.demo.Service.ProjectService;
import com.Project.demo.dto.ProjectDto;

@RestController()
@RequestMapping("/project")
public class ProjectController extends BaseController {

	@Autowired
	private ProjectService service;

	private Logger logger = LogManager.getLogger(ProjectController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProjectDto> ProjectView(@RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		logger.debug("Inside ProjectView");
		List<ProjectDto> listProject = service.ProjectlistAll(useremail);
		logger.debug("Exiting ProjectView");
		return listProject;
		// return "index.html";

	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveProject(@RequestBody ProjectDto projectRequest, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		service.createProject(projectRequest, useremail);
		logger.debug("After projectid");
		return "Created";
		// return "redirect:/";
	}

	@DeleteMapping(value = "/{projectid}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteProject(@PathVariable("projectid") Long projectid, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		logger.debug("Inside deleteproject");
		service.delete(projectid, useremail);
		logger.debug("Deleted project");
		return "redirect:/";
	}

	@PutMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public String editProject(@RequestBody ProjectDto projectRequest, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		service.edit(projectRequest, useremail);
		return "redirect:/";
	}

	@PostMapping(value = "/addTechnology/{projectId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addTechnologyToProject(@RequestHeader(Constants.loggedInUserEmail) String useremail, @PathVariable("projectId") Long projectId,
			@RequestParam("name") String technologyName) {
		checkemail(useremail);
		service.addTechnologyToProject(useremail, projectId, technologyName);
	}

	@DeleteMapping(value = "/removeTechnology/{projectId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeTechnologyFromProject(@RequestHeader(Constants.loggedInUserEmail) String useremail, @PathVariable("projectId") Long projectId,
			@RequestParam("name") String technologyName) {
		checkemail(useremail);
		service.removeTechnologyFromProject(useremail, projectId, technologyName);
	}

	@GetMapping(value = "/{projectId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProjectDto getProjectDetailsByProjectId(@RequestHeader(Constants.loggedInUserEmail) String useremail,
			@PathVariable("projectId") Long projectId) {
		checkemail(useremail);
		return service.getProjectDetailsByProjectId(useremail, projectId);
	}

	@GetMapping(value = "/{projectName}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProjectDto> getProjectDetailsByProjectName(@RequestHeader(Constants.loggedInUserEmail) String useremail,
			@PathVariable("projectName") String projectName) {
		checkemail(useremail);
		return service.getProjectDetailsByProjectName(useremail, projectName);
	}
}
