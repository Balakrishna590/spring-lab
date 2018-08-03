package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HrService {

	@Autowired
	RestTemplate rt;

	@HystrixCommand(fallbackMethod="handleFinder")
	public ResponseEntity processFind(int empid) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);
		ResponseEntity<String> response = rt.exchange("http://emp-data-service3/emp/"+empid, HttpMethod.GET, req,
				String.class);
		return response;
	}

	@HystrixCommand(fallbackMethod="handleList")
	public ResponseEntity processList() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");

		HttpEntity req = new HttpEntity(headers);
		ResponseEntity<String> response = rt.exchange("http://emp-data-service3/emp", HttpMethod.GET, req,
				String.class);
		return response;
	}
	
	//fallbacks
	
	
	public ResponseEntity handleFinder(int empid) {
		return ResponseEntity.ok("Service is currently Unavailable..Try after some time");
	}
	
	public ResponseEntity handleList() {
		return ResponseEntity.ok("List Emp Service is currently Unavailable..Try after some time");
	}
}
