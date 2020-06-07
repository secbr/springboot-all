package com.secbro.mapper;

import com.secbro.model.Order;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/1 10:01 AM
 **/
public interface OrderMapper {

	/**
	 * 更新订单
	 * @param order 订单信息
	 * @return 记录数
	 */
	int update(Order order);

	/**
	 * 根据ID查询
	 * @param id 订单id
	 * @return 订单详情
	 */
	Order findById(int id);

}
