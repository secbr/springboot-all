package com.secbro.service;

import com.secbro.model.User;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/1 6:03 PM
 **/
public interface UserService {

	/**
	 * 根据ID查询
	 *
	 * @param id 订单id
	 * @return 订单详情
	 */
	User findById(int id);
}
