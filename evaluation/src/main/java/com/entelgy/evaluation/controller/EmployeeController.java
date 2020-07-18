package com.entelgy.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.evaluation.model.EmployeeResponse;
import com.entelgy.evaluation.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public EmployeeResponse getEmployee() {

		return employeeService.findAll();
	}

}
