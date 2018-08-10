package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JdbcCodeRunner implements CommandLineRunner {

	@Autowired
	EmpDao dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside Runner");
		for (Employee e : dao.getAllEmps()) {
			System.out.println(e.getEmpId() + " " + e.getEmpName());
		}

	}

}
