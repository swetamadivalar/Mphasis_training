package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.Employee;
import com.test.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees/")
public class EmployeeController {

	private final EmployeeRepository employeeRepository;
	
	public EmployeeController(EmployeeRepository EmployeeRepository) {
		this.employeeRepository=EmployeeRepository;
	}
	
	@GetMapping("signup")
	public String showSignUpForm(Employee employee) {
		return "add-employee";
	}
	
	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("employees",employeeRepository.findAll());
		return "index1";
	}
	
	@PostMapping("add")
	public String addEmployee(@Valid Employee employee, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "add-employee";
		}
		employeeRepository.save(employee);
		return "redirect:list";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable long id,Model model) {
		Employee employee=employeeRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("invalid employee id:"+id)
				);
		model.addAttribute("employees",employee);
		return "update-employee";			
	}
	
	@PostMapping("update/{id}")
	public String updateEmployee(@PathVariable long id,
			@Valid Employee employee,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			employee.setId(id);
			return "update-employee";
		}
		employeeRepository.save(employee);
		
		model.addAttribute("employees",employeeRepository.findAll());
		return "index1";
	}
	
	@GetMapping("delete/{id}")
	public String deleteEmployee(@PathVariable long id,Model model) {
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee id:"+id));
		
		employeeRepository.delete(employee);
		model.addAttribute("employees",employeeRepository.findAll());
		return "index1";
	}
	
	
}
