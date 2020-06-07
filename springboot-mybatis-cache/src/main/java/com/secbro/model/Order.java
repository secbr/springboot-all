package com.secbro.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/28 4:48 PM
 **/
@Data
public class Order implements Serializable {

	private int id;

	private String orderNo;

	private int amount;
}
