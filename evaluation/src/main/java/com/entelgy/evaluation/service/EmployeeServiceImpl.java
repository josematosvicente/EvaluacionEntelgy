package com.entelgy.evaluation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.evaluation.dto.Employee;
import com.entelgy.evaluation.model.EmployeeList;
import com.entelgy.evaluation.model.EmployeeResponse;
import com.entelgy.util.Constants;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public EmployeeResponse findAll()
	{

	    EmployeeList entity =  restTemplate.getForObject(Constants.URI_SERVICE_EXTERNAL, EmployeeList.class);
	    List<String> lEmployee = new ArrayList<>();
	    for (Employee employee : entity.getData()) {
	    	lEmployee.add(String.valueOf(employee.getId()).concat(",").concat(employee.getName()));
		}
	    EmployeeResponse employeeResponse =new EmployeeResponse();
	    employeeResponse.setData(lEmployee);
	    return employeeResponse;
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
