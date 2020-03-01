package com.secbro.service;

import com.secbro.model.Order;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/29 8:58 AM
 **/
public interface OrderService {

	Order findByOrderNo(String orderNo);

}
