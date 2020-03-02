package com.secbro.service;

import com.secbro.model.Order;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/29 8:58 AM
 **/
public interface OrderService {

	/**
	 * 创建订单
	 *
	 * @param order 订单信息
	 * @return 记录数
	 */
	int save(Order order);

	/**
	 * 更新订单
	 *
	 * @param order 订单信息
	 * @return 记录数
	 */
	int update(Order order);

	/**
	 * 删除
	 *
	 * @param id id
	 * @return 条数
	 */
	int delete(int id);

	/**
	 * 根据ID查询
	 *
	 * @param id 订单id
	 * @return 订单详情
	 */
	Order findById(int id);

	Order findById1(int id);

	/**
	 * 查询所有用户
	 *
	 * @return 用户列表
	 */
	List<Order> findAll();

}
