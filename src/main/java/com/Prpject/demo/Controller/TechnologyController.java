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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Prpject.demo.Service.TechnologyService;
import com.Prpject.demo.model.Technology;

@RestController()
@RequestMapping("/technology")
public class TechnologyController {

	@Autowired
	private TechnologyService service;

	private Logger logger = LogManager.getLogger(TechnologyController.class);

	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Technology> TechnologyView() {
		logger.debug("Inside TechnologyView");
		List<Technology> listTechnology = service.TechnologylistAll();
		logger.debug("Exiting TechnologyView");
		return listTechnology;
//		return "index.html";

	}

	@PostMapping(value = "/{tech}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String saveTechnology(@PathVariable("tech") String tech) {
		logger.debug("Inside SaveTechnology");
		Technology technology = new Technology();
		technology.setTechnologyName(tech);
		logger.debug("Setting TechnologyName");
		service.save(technology);
		logger.debug("After SavingTechnology");
		return "Created";
//		return "redirect:/";
	}

	@DeleteMapping(value = "/{tech}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteTechnology(@PathVariable("tech") String tech) {
		logger.debug("Inside deleteTechnology");
		service.delete(tech);
		logger.debug("Deleting Technology");
		return "redirect:/";
	}
	
	@GetMapping(value = "/{tech}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<Technology> technologyViewByName(@PathVariable("tech") String tech){
		return service.findByName(tech);
	}

}
