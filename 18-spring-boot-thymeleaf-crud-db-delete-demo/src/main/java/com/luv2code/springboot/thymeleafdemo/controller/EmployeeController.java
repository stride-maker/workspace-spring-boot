package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/list")
	public String getEmployeeList(Model theModel) {
		
		List<Employee> employeeList = employeeService.findAll();
		
		theModel.addAttribute("employees", employeeList);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.save(employee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateEmployee(@RequestParam("employeeId") int theId, Model theModel) {
		
		Employee theEmployee = employeeService.findById(theId);
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		employeeService.deleteById(theId);
		return "redirect:/employees/list";
	}
}
