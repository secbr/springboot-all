package com.secbro.service.impl;

import com.secbro.entity.User;
import com.secbro.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:35 AM
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

	/**
	 * 确保原子性，用于生产User的id
	 */
	private static AtomicLong idProducer = new AtomicLong();

	/**
	 * 内存中存储User对象，支持高并发，key为User对象ID，value为User对象
	 */
	private final Map<Long, User> users = new ConcurrentHashMap<>();


	@Override
	public User addUser(User user) {
		if (user.getId() == null) {
			Long id = idProducer.incrementAndGet();
			user.setId(id);
			users.put(id, user);
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		return new ArrayList<>(users.values());
	}

	@Override
	public User update(User user) {
		// 覆盖更新
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public User updateUsername(User user) {
		User tempUser = users.get(user.getId());
		tempUser.setUsername(user.getUsername());
//		users.put(user.getId(), tempUser);
		return tempUser;
	}

	@Override
	public User findById(Long id) {
		return users.get(id);
	}

	@Override
	public void delete(Long id) {
		users.remove(id);
	}

}
