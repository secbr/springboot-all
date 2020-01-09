package com.secbro2.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getAmountByAccountNo() throws Exception {
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.get("/getAmountByAccountNo")
		).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		log.info("请求返回状态:{}", response.getStatus());
		log.info("请求返回信息:{}", response.getContentAsString());
	}

	@Test
	void addUser() throws Exception {
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post("/addUser")
		).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		log.info("请求返回状态:{}", response.getStatus());
		log.info("请求返回信息:{}", response.getContentAsString());
	}
}