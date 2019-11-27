/*
 * package com.tutorial.spring.springboot.springdDataJPA.cruddemo.rest;
 * 
 * import java.util.List; import java.util.Random;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import
 * com.tutorial.spring.springboot.springdDataJPA.cruddemo.entity.Employee;
 * import com.tutorial.spring.springboot.springdDataJPA.cruddemo.service.
 * EmployeeServiceDataJpa;
 * 
 * 
 * @RestController
 * 
 * @RequestMapping("/datajpa/employees") public class
 * DataJPAEmployeeRestController {
 * 
 * private EmployeeServiceDataJpa employeeService;
 * 
 * @Autowired public
 * DataJPAEmployeeRestController( @Qualifier("employeeRestController")
 * EmployeeServiceDataJpa employeeService) { this.employeeService =
 * employeeService; }
 * 
 * @GetMapping("/") public String welcomePage() { return
 * "welcome to employees page"; }
 * 
 * @GetMapping("/showAll") public List<Employee> getAllEmployees() {
 * List<Employee> empList = employeeService.findAll(); return empList; }
 * 
 * @GetMapping("/showdetails/{employeeId}") public Employee
 * getEmployeeDetails(@PathVariable int employeeId) { return
 * employeeService.findById(employeeId); }
 * 
 * @PostMapping("/save") public Employee save(@RequestBody Employee employee) {
 * employee.setEmployeeId(new Random().nextInt());
 * employeeService.save(employee); return employee; }
 * 
 * 
 *//**
	 * update
	 */
/*
 * @PutMapping("/update") public Employee update(@RequestBody Employee employee)
 * { employeeService.save(employee); return employee; }
 * 
 *//**
	 * delete
	 *//*
		 * 
		 * @DeleteMapping("/delete/{empId}") public String delete(@PathVariable int
		 * empId) { if(employeeService.deleteById(empId)) return
		 * "Employee with empId = "+empId+" is sucessfully deleted."; else return
		 * "employee is not sucessfully deleted"; } }
		 */