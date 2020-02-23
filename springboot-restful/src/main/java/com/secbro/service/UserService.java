package com.secbro.service;

import com.secbro.entity.User;

import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:37 AM
 **/
public interface UserService {

	/**
	 * 新增用户
	 */
	User addUser(User user);

	/**
	 * 查询所有User
	 */
	List<User> findAll();

	/**
	 * 覆盖更新User
	 */
	User update(User user);

	/**
	 * 更新User的名称
	 */
	User updateUsername(User user);

	/**
	 * 查询
	 */
	User findById(Long id);

	/**
	 * 删除
	 */
	void delete(Long id);

}
