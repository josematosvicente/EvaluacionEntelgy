package com.entelgy.evaluation.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.entelgy.evaluation.model.EmployeeResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static final Logger logger = LoggerFactory.getLogger(EmployeeControllerTest.class);

	@Test
	public void getProductsList() throws Exception {
		String uri = "/api/v1/employees";
		String response = mockMvc.perform(post(uri)).andExpect(status().is(HttpStatus.OK.value())).andReturn()
				.getResponse().getContentAsString();

		EmployeeResponse productlist = mapFromJson(response, EmployeeResponse.class);
		assertTrue(productlist.getData().size() > 0);
		logger.info("response: " + productlist.getData().size());

	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

}
