package com.Prpject.demo.Controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Prpject.demo.Service.EmployeeService;
import com.Prpject.demo.model.Employee;




@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	 @GetMapping(value="/employee") 
	  public String viewHomePage(Model model) {
		  List<Employee> listEmployee = service.listAll(); 
		  model.addAttribute("listemployee",listEmployee); 
		  System.out.print("Get / "); 
	          return "index.html";
	  
	  }
	 
	 @GetMapping("/newemployee")
		public String addEmployee(Model model) {
			model.addAttribute("Employee", new Employee());
			return "new";
		}

		@RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
		@ResponseBody 
		public String saveEmployee(@ModelAttribute("Employee") Employee std) {
			service.save(std);
			return "redirect:/";
		}

		@RequestMapping("/editemployee/{id}")
		public ModelAndView EditEmployeePage(@PathVariable(name = "id") int id) {
			ModelAndView mav = new ModelAndView("new");
			Employee std = service.get(id);
			mav.addObject("Employee", std);
			return mav;

		}

		@RequestMapping("/deleteemployee/{id}")
		public String deleteEmployee(@PathVariable(name = "id") int id) {
			service.delete(id);
			return "redirect:/";
		}

}
