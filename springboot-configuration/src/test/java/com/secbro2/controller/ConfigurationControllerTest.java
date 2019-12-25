package com.secbro2.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zzs
 */
@SpringBootTest
@AutoConfigureMockMvc
class ConfigurationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getInfo() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/"));
	}

	@Test
	void getUser() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/user"));
	}
}