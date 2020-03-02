package com.secbro.mapper.db2;

import com.secbro.model.User;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/1 10:01 AM
 **/
public interface UserMapper {

	/**
	 * 创建订单
	 *
	 * @param user 订单信息
	 * @return 记录数
	 */
	int save(User user);

	/**
	 * 更新订单
	 *
	 * @param user 订单信息
	 * @return 记录数
	 */
	int update(User user);

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
	User findById(int id);

	/**
	 * 查询所有用户
	 *
	 * @return 用户列表
	 */
	List<User> findAll();
}
