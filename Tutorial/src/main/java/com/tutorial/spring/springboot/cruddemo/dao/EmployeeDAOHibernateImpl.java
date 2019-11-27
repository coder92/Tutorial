package com.tutorial.spring.springboot.cruddemo.dao;

import com.tutorial.spring.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

	//define entity manager 
	
	
	/*
	 * private EntityManager entityManager;
	 * 
	 * @Autowired public EmployeeDAOHibernateImpl(EntityManager entityManager) {
	 * this.entityManager = entityManager; }
	 */
	 
	
	@Override
	public List<Employee> findAll() {
		
		//get current hibernate session
		
		
		
		//create a query 
		
		//execute the query 
		
		//get the result 
		
		//return the result
		return null;
	}

	@Override
	public Employee findByID(int id) {
		
		return null;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

}
