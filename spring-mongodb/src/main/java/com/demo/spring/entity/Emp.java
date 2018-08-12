package com.demo.spring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Emp {

	@Id
	private String empId;
	private String name;
	private String city;
	private double salary;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Emp(String name, String city, double salary) {
		//this.empId = empId;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}



	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
