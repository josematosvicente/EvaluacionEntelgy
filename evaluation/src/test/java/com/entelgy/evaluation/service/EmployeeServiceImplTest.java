package com.entelgy.evaluation.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.entelgy.evaluation.dto.Employee;
import com.entelgy.evaluation.model.EmployeeList;
import com.entelgy.evaluation.model.EmployeeResponse;
import com.entelgy.util.Constants;

@SpringBootTest
class EmployeeServiceImplTest {

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Mock
	private RestTemplate restTemplate = new RestTemplate();

	@Test
	void getAllEmployeesTest() {
		EmployeeList mockupEmployee = new EmployeeList();
		List<Employee> lEmployee = new ArrayList<Employee>();
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Tiger Nixon");
		lEmployee.add(employee);
		mockupEmployee.setData(lEmployee);

		Mockito.when(restTemplate.getForObject(Constants.URI_SERVICE_EXTERNAL, EmployeeList.class)).thenReturn(mockupEmployee);

		EmployeeResponse employeeResponse = new EmployeeResponse();
		List<String> data = new ArrayList();
		data.add("1,Tiger Nixon");
		employeeResponse.setData(data);

		EmployeeResponse returnEmployee = employeeService.findAll();
		assertThat(employeeResponse).isEqualToComparingFieldByField(returnEmployee);
	}

}
