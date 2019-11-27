/*
 * package com.tutorial.spring.springboot.springDataRest.crudDemo.dao;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.stereotype.Repository;
 * 
 * import
 * com.tutorial.spring.springboot.springDataRest.crudDemo.entity.Employee;
 * 
 * 
 *//**
	 * Rest point exposed by spring is EntityClassName(first letter small) followed
	 * by s ex. /employees
	 */
/*
*//**
	 * but if we want - different name ex. /members then need to add
	 * 
	 * @RepositoryRestResource(path="members")
	 * 
	 * 										@author Ankit.Dixit
	 *
	 *//*
		 * 
		 * 
		 * //@RepositoryRestResource(path="members") public interface EmployeeRepository
		 * extends JpaRepository<Employee, Integer>{
		 * 
		 * }
		 * 
		 */