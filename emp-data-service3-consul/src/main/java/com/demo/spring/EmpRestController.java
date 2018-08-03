package com.demo.spring;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dao.EmpRepository;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	EmpRepository dao;
	// @RequestMapping(path = "/info", method = RequestMethod.GET)

	@GetMapping("/info")
	public String getInfo() {
		return "this is a Spring REST Service";
	}

	@GetMapping(path = "/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity findEmp(@PathVariable("id") int id) {
		Optional<Emp> o = dao.findById(id);
		if (o.isPresent())
			return ResponseEntity.ok(o.get());
		else
			return ResponseEntity.ok("Emp does not exist");

	}

	@GetMapping(path = "/emp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity listEmps() {
		List<Emp> empList = dao.findAll();
		return ResponseEntity.ok(empList);
	}

	@PostMapping(path = "/emp/save", produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity saveEmp(@RequestBody @Valid Emp e) {
	
		if (!dao.existsById(e.getEmpId())) {
			Emp emp = dao.save(e);
			return ResponseEntity.ok("Emp saved ...");
		} else {
			return ResponseEntity.ok("Emp Already exists..");
		}

	}
}
