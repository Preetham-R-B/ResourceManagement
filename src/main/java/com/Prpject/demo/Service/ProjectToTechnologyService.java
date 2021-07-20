//package com.Prpject.demo.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.Prpject.demo.dao.ProjectRepo;
//import com.Prpject.demo.dao.ProjectToTechnologyRepo;
//import com.Prpject.demo.dao.TechnologyRepo;
//import com.Prpject.demo.model.ProjectToTechnology;
//
//@Service
//public class ProjectToTechnologyService {
//	
//	@Autowired
//	ProjectToTechnologyRepo projectToTechnologyRepo;
//	
//	@Autowired
//	ProjectRepo projectRepo;
//	
//	@Autowired
//	TechnologyRepo technologyRepo;
//
//	public void save(Long projectId, Long technologyId) {
//		
//		ProjectToTechnology ptt = new ProjectToTechnology();
//		
//		ptt.setProject(projectRepo.findById(projectId).get());
//		ptt.setTechnology(technologyRepo.findById(technologyId).get());
//		projectToTechnologyRepo.save(ptt);
//	}
//
//}
