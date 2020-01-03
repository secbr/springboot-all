package com.choupangxia.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author zzs
 */
@SpringBootTest
@AutoConfigureMockMvc
class ColorControllerTest {

	private Logger logger = LoggerFactory.getLogger(ColorControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getColor() throws Exception {

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/color/getColor")).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		logger.info("返回结果信息：{}", result);
	}

	@Test
	void postColor() throws Exception {
		String webColor = "{\"webColor\":\"#f0f7ff\"}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/color/postColor").param("webColor", webColor)
		);
	}
}