package com.secbro.service.impl;

import com.secbro.mapper.db2.UserMapper;
import com.secbro.model.User;
import com.secbro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sec
 * @version 1.0
 * @date 2020/3/1 6:03 PM
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User findById(int id) {
		return userMapper.findById(id);
	}
}
