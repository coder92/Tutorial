package com.tutorial.spring.springboot.cruddemo.dao;

import com.tutorial.spring.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	
	public Employee findByID(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);

}
