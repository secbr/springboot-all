package com.secbro2.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


/**
 * @author zzs
 */
@SpringBootTest
class DbServiceTest {

	@Resource
	private DbService dbService;

	@Test
	void getDbInfo() {
		dbService.getDbInfo();
	}
}