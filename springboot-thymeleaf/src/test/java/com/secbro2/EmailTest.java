package com.secbro2;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/15 9:56 AM
 **/
@Slf4j
@SpringBootTest
public class EmailTest {
	@Autowired
	private TemplateEngine templateEngine;

	@Test
	public void testSendEmail() {
		Context context = new Context();
		context.setVariable("name", "Tom");
		context.setVariable("position", "项目经理");
		context.setVariable("salary", 50000);
		String mail = templateEngine.process("email", context);
		log.info(mail);
	}
}
