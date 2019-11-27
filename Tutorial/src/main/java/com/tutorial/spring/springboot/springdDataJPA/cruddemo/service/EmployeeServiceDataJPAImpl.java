/*
 * package com.tutorial.spring.springboot.springdDataJPA.cruddemo.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.tutorial.spring.springboot.springdDataJPA.cruddemo.dao.
 * DataJPAEmployeeRepository; import
 * com.tutorial.spring.springboot.springdDataJPA.cruddemo.entity.Employee;
 * 
 * @Service //@Transactional public class EmployeeServiceDataJPAImpl implements
 * EmployeeServiceDataJpa{
 * 
 * 
 * private DataJPAEmployeeRepository employeeRepositoty ;
 * 
 * @Autowired public EmployeeServiceDataJPAImpl( DataJPAEmployeeRepository
 * employeeRepository) { this.employeeRepositoty = employeeRepository; }
 * 
 * @Override public List<Employee> findAll() { return
 * employeeRepositoty.findAll(); }
 * 
 * @Override public Employee findById(int id) { return
 * employeeRepositoty.findById(id).get(); }
 * 
 * @Override public void save(Employee employee) {
 * employeeRepositoty.save(employee); }
 * 
 * @Override public boolean deleteById(int id) { try {
 * employeeRepositoty.deleteById(id); }catch(Exception e) { return false; }
 * return true; }
 * 
 * }
 * 
 * 
 */