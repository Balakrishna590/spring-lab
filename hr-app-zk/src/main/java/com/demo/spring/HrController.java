package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrController {

	@Autowired
	HrService service;

	@GetMapping(path = "/hr/find")
	public ResponseEntity findEmp(@RequestParam("id") int id) {
		return service.processFind(id);
	}

	@GetMapping(path = "/hr/list")
	public ResponseEntity list() {
		return service.processList();
	}
}
