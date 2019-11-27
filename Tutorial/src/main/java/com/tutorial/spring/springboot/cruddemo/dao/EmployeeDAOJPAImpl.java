package com.tutorial.spring.springboot.cruddemo.dao;

import com.tutorial.spring.springboot.cruddemo.entity.Employee;

import java.util.List;

public class EmployeeDAOJPAImpl implements EmployeeDAO{

	//private EntityManager entityManager;
	
	/*
	 * @Autowired public EmployeeDAOJPAImpl(@Qualifier("employeeDAOJPAImpl")
	 * EntityManager entityManager) { this.entityManager = entityManager; }
	 */
	
	@Override
	//@Transactional
	public List<Employee> findAll() {
		
		/*
		 * Query query = entityManager.createQuery("from Employee");
		 * 
		 * List<Employee> employees = query.getResultList();
		 */
		return null;
	}

	@Override
	public Employee findByID(int id) {
		// TODO Auto-generated method stub
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
