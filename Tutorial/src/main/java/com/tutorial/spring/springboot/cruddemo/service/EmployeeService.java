package com.tutorial.spring.springboot.cruddemo.service;

import com.tutorial.spring.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public boolean deleteById(int id);
	
}
