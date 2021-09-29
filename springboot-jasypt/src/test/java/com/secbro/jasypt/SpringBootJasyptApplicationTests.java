package com.secbro.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootJasyptApplicationTests {

	@Autowired
	private StringEncryptor stringEncryptor;

	@Test
	void contextLoads() {
		String qwerty1234 = stringEncryptor.encrypt("admin123");
		System.out.println(qwerty1234);
	}

}
