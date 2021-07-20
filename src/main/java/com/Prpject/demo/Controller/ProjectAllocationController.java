//package com.Prpject.demo.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Project.demo.dto.ProjectAllocationRequest;
//import com.Prpject.demo.Service.ProjectAllocationService;
//
//@RestController
//@RequestMapping("/ProjectToEmployee")
//public class ProjectAllocationController {
//
//	@Autowired
//	private ProjectAllocationService projectAllocationService;
//
//	@PostMapping(value = "/{projectId}")
//	@ResponseStatus(code = HttpStatus.CREATED)
//	public void assignEmployeetoProject(@PathVariable("projectId") long projectId,
//			@RequestParam("employeeId") long employeeId) {
//		projectAllocationService.save(projectId, employeeId);
//	}
//
//}
