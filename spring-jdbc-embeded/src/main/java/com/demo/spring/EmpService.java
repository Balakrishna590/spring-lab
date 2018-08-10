package com.demo.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	
	EmpDao dao;
	
	/*public void setDao(EmpDao dao) {
		this.dao = dao;
	}*/


	public String registerEmployee(int id, String name, String city, double salary) {
		String resp = dao.saveEmp(new Employee(id, name, city, salary));
		if (resp.equals("saved"))
			return "Emp Registered";
		return "Problem Occurred";
	}
	
	public String saveEmpCollection(List<Employee> emps){
		return dao.saveAll(emps);
	}
}
