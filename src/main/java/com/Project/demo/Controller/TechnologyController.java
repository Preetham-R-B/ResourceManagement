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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Project.demo.Constants;
import com.Project.demo.Service.TechnologyService;
import com.Project.demo.dto.TechnologyDto;

@RestController()
@RequestMapping("/technology")
public class TechnologyController extends BaseController {

	@Autowired
	private TechnologyService service;

	private Logger logger = LogManager.getLogger(TechnologyController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<TechnologyDto> TechnologyView(@RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		logger.debug("Inside TechnologyView");
		List<TechnologyDto> listTechnology = service.TechnologylistAll();
		logger.debug("Exiting TechnologyView");
		return listTechnology;
		// return "index.html";

	}

	@PostMapping(value = "/{tech}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String createTechnology(@PathVariable("tech") String tech, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		logger.debug("Inside SaveTechnology");
		service.createTechnology(tech, useremail);
		return "Sucess";
		// return "redirect:/";
	}

	@DeleteMapping(value = "/{tech}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteTechnology(@PathVariable("tech") String tech, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		logger.debug("Inside deleteTechnology");
		service.delete(tech, useremail);
		logger.debug("Deleting Technology");
		return "redirect:/";
	}

	@GetMapping(value = "/{tech}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<TechnologyDto> technologyViewByName(@PathVariable("tech") String tech, @RequestHeader(Constants.loggedInUserEmail) String useremail) {
		checkemail(useremail);
		return service.findByName(tech);
	}

}
