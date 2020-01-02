package com.choupangxia.entity;

import com.choupangxia.serializer.OrderDeserializer;
import com.choupangxia.serializer.OrderSerializer;
import com.choupangxia.serializer.StringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * @author sec
 * @version 1.0
 * @date 2020/1/2 11:01 AM
 **/
//@JsonSerialize(using = OrderSerializer.class)
@JsonDeserialize(using = OrderDeserializer.class)
public class Order {

	private String orderNo;

	private double amount;

	private Date orderDate;

	@JsonSerialize(using = StringSerializer.class)
	private String type;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
