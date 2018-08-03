package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "GreeterApp")
@RequestMapping("/app")
public class GreetController {

	@ApiOperation(value="greets a named person")
	@GetMapping(path = "/greet", produces = "text/plain")
	public String greet(@RequestParam("name") String name) {
		return "Welcome To Swagger " + name;
	}
}
