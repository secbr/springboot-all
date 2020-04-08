package com.secbro.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/28 4:48 PM
 **/
@Data
@TableName("tb_order")
public class Order {

	private int id;

	private String orderNo;

	private int amount;
}
