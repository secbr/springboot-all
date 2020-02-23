package com.secbro.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zzs
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class RestfulControllerTest {

	private AtomicLong idProducer = new AtomicLong();

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void init() throws Exception {
		for (int i = 0; i < 3; i++) {
			MvcResult mvcResult =
					mockMvc.perform(MockMvcRequestBuilders.post("/user").param("username",
							"user" + idProducer.incrementAndGet())).andReturn();
			log.info("result={}", mvcResult.getResponse().getContentAsString());
		}
	}

	@Test
	void addUser() throws Exception {
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user").param("username",
				"user" + idProducer.incrementAndGet())).andReturn();
		log.info("result={}", mvcResult.getResponse().getContentAsString());
	}

	@Test
	void listUser() throws Exception {
		MvcResult mvcResult =
				mockMvc.perform(MockMvcRequestBuilders.get("/user/list")).andReturn();
		log.info("result={}", mvcResult.getResponse().getContentAsString());
	}

	@Test
	void update() throws Exception {
		MvcResult mvcResult =
				mockMvc.perform(MockMvcRequestBuilders.put("/user").param("id", "1").param("username", "Tom")).andReturn();
		log.info("result={}", mvcResult.getResponse().getContentAsString());
		listUser();
	}

	@Test
	void updateUsername() throws Exception {
		MvcResult mvcResult =
				mockMvc.perform(MockMvcRequestBuilders.patch("/user").param("id", "1").param("username", "Tom")).andReturn();
		log.info("result={}", mvcResult.getResponse().getContentAsString());
		listUser();
	}

	@Test
	void get() throws Exception {
		MvcResult mvcResult =
				mockMvc.perform(MockMvcRequestBuilders.get("/user/2")).andReturn();
		log.info("result={}", mvcResult.getResponse().getContentAsString());
	}

	@Test
	void delete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/2")).andReturn();
		listUser();
	}

}