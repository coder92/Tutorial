package com.tutorial.spring.springboot.springdDataJPA.cruddemo.entity;

/**
 * @author Ankit.Dixit
 *
 */
public class Employee {
	
	private String name;
	private int age;
	private int employeeId;
	private String department;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", employeeId=" + employeeId + ", department=" + department
				+ "]";
	}
}
