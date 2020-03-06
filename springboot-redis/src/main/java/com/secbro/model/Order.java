package com.secbro.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class Order implements Serializable {

	private int id;

	private String orderNo;

	private int amount;
}
