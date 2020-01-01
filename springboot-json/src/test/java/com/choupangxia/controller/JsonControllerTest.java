package com.choupangxia.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zzs
 */
@SpringBootTest
@AutoConfigureMockMvc
class JsonControllerTest {

	private Logger logger = LoggerFactory.getLogger(JsonControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getUserInfo() throws Exception {

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/userInfo")).andReturn();
		String result = mvcResult.getResponse().getContentAsString();

		System.out.println("返回结果信息：" + result);
	}

	@Test
	void addUser() throws Exception {
		String user = "{\"userNo\":\"1000\",\"username\":\"Tom\",\"age\":18,\"createDate\":\"2019-12-31 05:12:42" +
				"\"}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/addUser").content(user).contentType(MediaType.APPLICATION_JSON_VALUE)
		);
	}

	@Test
	void writeString() throws Exception {

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/writeString")).andReturn();
		String result = mvcResult.getResponse().getContentAsString();

		logger.info("返回结果信息：{}",result);
	}

	@Test
	void readJson() throws Exception {
		String userJson = "{\"userNo\":\"1000\",\"username\":\"Tom\",\"age\":18,\"createDate\":\"2019-12-31 05:12:42" +
				"\"}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/readJson").param("userJson",userJson)
		);
	}
}