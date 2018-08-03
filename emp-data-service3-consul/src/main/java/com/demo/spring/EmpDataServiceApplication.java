package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.demo.spring.dao")
@EnableDiscoveryClient
public class EmpDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpDataServiceApplication.class, args);
	}
}
