package com.tutorial.spring.springboot.cruddemo.service;

import com.tutorial.spring.springboot.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
//@Transactional
public class EmployeeServiceImpl  implements EmployeeService{

	
	//actual implementation
	
	
	/**
	 * Dummy response till the database connectivity is not ok.
	 */
	Employee employeeObj = new Employee();
	
	Map<Integer, Employee> employeeDB = new HashMap<Integer, Employee>();
	//instance block 
	
	{
		employeeObj.setAge(27);
		employeeObj.setDepartment("Monitor");
		employeeObj.setEmployeeId(295);
		employeeObj.setName("Ankit Dixit");
		
		employeeDB.put(employeeObj.getEmployeeId(), employeeObj);
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> empList = new ArrayList<Employee>();
		
		for(Employee emp : employeeDB.values()) {
			empList.add(emp);
		}
		return empList;
	}

	@Override
	public Employee findById(int id) {
		
		return employeeDB.get(id);
	}

	@Override
	public void save(Employee employee) {
		int id = createNewUniqueKey(10000);
		employeeDB.put(id, employee);
	}

	private int createNewUniqueKey(int i) {
		Random r = new Random();
		
		return r.nextInt(i);
	}

	@Override
	public boolean deleteById(int id) {
		if(employeeDB.remove(id)!=null)
			return true;
		else
			return false;
	}

}


