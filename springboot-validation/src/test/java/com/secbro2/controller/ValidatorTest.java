package com.secbro2.controller;

import com.secbro2.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


/**
 * @author sec
 * @version 1.0
 * @date 2020/1/8 4:37 PM
 **/
@Slf4j
@SpringBootTest
public class ValidatorTest {

	@Autowired
	private Validator validator;

	@Test
	void testValidator() {

		Order order = new Order();
		order.setRequestNo("");
		order.setAmount(0);
		order.setPhone("11111111111");

		Set<ConstraintViolation<Order>> validate = validator.validate(order);
		if (!validate.isEmpty()) {
			validate.forEach((violation) -> {
				log.info(violation.getMessage());
			});
		}

	}
}