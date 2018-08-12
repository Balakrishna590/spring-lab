package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.spring.entity.Emp;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		MongoOperations mongo = ctx.getBean(MongoTemplate.class);

		mongo.insert(new Emp("Ruman", "Hyderabad", 45000));
		System.out.println("done");

		Emp e = mongo.findOne(new Query(Criteria.where("name").is("Ruman")), Emp.class);
		System.out.println(e.getName());
	}
}
