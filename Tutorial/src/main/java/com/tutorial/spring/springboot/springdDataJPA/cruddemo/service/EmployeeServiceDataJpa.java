package com.tutorial.spring.springboot.springdDataJPA.cruddemo.service;

import com.tutorial.spring.springboot.springdDataJPA.cruddemo.entity.Employee;

import java.util.List;


public interface EmployeeServiceDataJpa {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public boolean deleteById(int id);
}
