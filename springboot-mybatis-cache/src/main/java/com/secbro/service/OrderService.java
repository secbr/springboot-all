package com.secbro.service;

import com.secbro.model.Order;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/29 8:58 AM
 **/
public interface OrderService {

	/**
	 * 根据ID查询
	 *
	 * @param id 订单id
	 * @return 订单详情
	 */
	Order findById(int id);

}
