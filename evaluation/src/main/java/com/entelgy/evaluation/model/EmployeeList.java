package com.entelgy.evaluation.model;

import java.util.List;

import com.entelgy.evaluation.dto.Employee;

public class EmployeeList {

	private String status;

	private List<Employee> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

}
