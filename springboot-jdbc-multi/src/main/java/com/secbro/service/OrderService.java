package com.secbro.service;

import com.secbro.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/29 8:58 AM
 **/
public interface OrderService {

	/**
	 * 创建订单
	 * @param order 订单信息
	 * @return 记录数
	 */
	int save(Order order);

	/**
	 * 保存到指定库
	 * @param order 订单信息
	 * @param jdbcTemplate jdbc
	 * @return
	 */
	int save(Order order, JdbcTemplate jdbcTemplate);

	/**
	 * 更新订单
	 * @param order 订单信息
	 * @return 记录数
	 */
	int update(Order order);

	/**
	 * 删除
	 * @param id id
	 * @return 条数
	 */
	int delete(int id);

	/**
	 * 根据ID查询
	 * @param id 订单id
	 * @return 订单详情
	 */
	Order findById(int id);

	/**
	 * 查询所有用户
	 * @return 用户列表
	 */
	List<Order> findAll();

	/**
	 * queryForList错误使用示范
	 * @return
	 */
	List<Order> findAllError();



}
