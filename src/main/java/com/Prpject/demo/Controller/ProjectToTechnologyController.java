//package com.Prpject.demo.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Prpject.demo.Service.ProjectToTechnologyService;
//
//@RestController
//@RequestMapping("/ProjectToTechnology")
//public class ProjectToTechnologyController {
//	
//	@Autowired
//	ProjectToTechnologyService projectToTechnologyService;
//	
//	@PostMapping("/{projectId}")
//	public void assignTechnologyToProject(@PathVariable("projectId") Long projectId, @RequestParam("technologyId") Long technologyId) {
//		projectToTechnologyService.save(projectId,technologyId);
//	}
//	
//
//}
