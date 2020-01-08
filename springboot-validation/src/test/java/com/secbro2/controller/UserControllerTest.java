package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void saveUser() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/saveUser")
		);
	}

	@Test
	void saveUserDetail() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/saveUserDetail")
		);
	}
}