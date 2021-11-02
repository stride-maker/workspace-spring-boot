package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employeesList;
	
	@PostConstruct
	private void loadData() {
		
		Employee firstEmployee = new Employee(1, "Mohit", "Chaudhary", "stridemaker@gmail.com");
		Employee secondEmployee = new Employee(1, "Nisha", "Dhama", "mohitch.work@gmail.com");
		Employee thirdEmployee = new Employee(1, "Yashpal", "Singh", "yashpal.singh@gmail.com");
		
		employeesList = new ArrayList<>();
		
		employeesList.add(firstEmployee);
		employeesList.add(secondEmployee);
		employeesList.add(thirdEmployee);
	}
	
	@GetMapping("/list")
	public String getEmployeeList(Model theModel) {
		
		theModel.addAttribute("employees", employeesList);
		
		return "list-employees";
	}
	
}
