package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void buy() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/buy")
						.param("requestNo", "")
						.param("amount", "0")
						.param("phone", "11111111111")
		);
	}
}