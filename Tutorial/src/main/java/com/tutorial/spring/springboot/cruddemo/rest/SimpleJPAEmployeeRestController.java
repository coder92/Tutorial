package com.tutorial.spring.springboot.cruddemo.rest;

import com.tutorial.spring.springboot.cruddemo.entity.Employee;
import com.tutorial.spring.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/simplejpa/employees")
public class SimpleJPAEmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public SimpleJPAEmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public String welcomePage() {
		return "welcome to employees page";
	}
	
	@GetMapping("/showAll")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = employeeService.findAll();
		return empList;
	}
	
	@GetMapping("/showdetails/{employeeId}")
	public Employee getEmployeeDetails(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		employee.setEmployeeId(new Random().nextInt());
		employeeService.save(employee);
		return 	employee;
	}
	
	
	/**
	 * update 
	 */
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	/**
	 * delete
	 */
	
	@DeleteMapping("/delete/{empId}")
	public String delete(@PathVariable int empId) {
		if(employeeService.deleteById(empId))
			return "Employee with empId = "+empId+" is sucessfully deleted.";
		else
			return "employee is not sucessfully deleted";
	}
}
