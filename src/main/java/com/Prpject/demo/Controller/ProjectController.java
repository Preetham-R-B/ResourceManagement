package com.Prpject.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Prpject.demo.Service.ProjectService;
import com.Prpject.demo.model.Project;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService service;

	@GetMapping("/project")
	public String viewProject(Model model) {
		List<Project> listProject = service.ProjectlistAll();
		model.addAttribute("listProject", listProject);
		System.out.print("Get / ");
		return "index.html";

	}

	@GetMapping("/newproject")
	public String addProject(Model model) {
		model.addAttribute("Project", new Project());
		return "new";
	}

	@RequestMapping(value = "/saveproject", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute("Project") Project std) {
		service.save(std);
		return "redirect:/";
	}

	@RequestMapping("/editproject/{id}")
	public ModelAndView EditProjectPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("new");
		Project std = service.get(id);
		mav.addObject("Project", std);
		return mav;

	}

	@DeleteMapping("/deleteproject/{id}")
	public String deleteProject(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}

}
