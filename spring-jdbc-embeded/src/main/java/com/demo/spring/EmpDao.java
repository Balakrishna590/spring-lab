package com.demo.spring;

import java.util.List;

public interface EmpDao {

	public String saveEmp(Employee e);
	
	public List<Employee> getAllEmps();
	public Employee findById(int empid);
	public String deleteEmp(int empId);
	public Employee updateEmp(Employee e);
	
	public String saveAll(List<Employee> empList);
}
