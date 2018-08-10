package com.demo.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		EmpService service=(EmpService)ctx.getBean("empService");
		
		//service.registerEmployee(106, "Mohan", "Chennai", 89000);
		
		List<Employee> emps= new ArrayList<>();
		emps.add(new Employee(206, "F", "Hyderabad", 34000));
		emps.add(new Employee(207, "G", "Hyderabad", 34000));
		emps.add(new Employee(208, "H", "Hyderabad", 34000));
		emps.add(new Employee(204, "I", "Hyderabad", 34000));
		emps.add(new Employee(209, "J", "Hyderabad", 34000));
		
		service.saveEmpCollection(emps);
	
	
	}

}
