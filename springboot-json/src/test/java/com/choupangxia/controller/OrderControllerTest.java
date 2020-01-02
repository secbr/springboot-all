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
class OrderControllerTest {

	private Logger logger = LoggerFactory.getLogger(OrderControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Test
	void getOrderInfo() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/order/getOrderInfo")).andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		logger.info("返回结果信息：{}", result);
	}

	@Test
	void addOrder() throws Exception {
		String order = "{\"orderNo\":\"NO1000\",\"amount\":124.00}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/order/addOrder").param("orderJson", order)
		);
	}

}