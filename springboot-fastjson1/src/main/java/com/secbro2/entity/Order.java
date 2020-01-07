package com.secbro2.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/7 4:53 PM
 **/
@Data
public class Order {

	private String orderNo;

	private BigDecimal amount;

}
