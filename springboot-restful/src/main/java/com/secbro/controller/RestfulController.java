package com.secbro.controller;

import com.secbro.entity.User;
import com.secbro.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:17 AM
 **/
@RestController
@RequestMapping("/user")
public class RestfulController {

	@Resource
	private UserService userService;

	/**
	 * 创建用户操作
	 */
	@PostMapping
	public User addUser(User user) {
		return userService.addUser(user);
	}

	/**
	 * 获取所需用户操作
	 */
	@GetMapping("/list")
	public List<User> listUser() {
		return userService.findAll();
	}

	/**
	 * 更新用户
	 */
	@PutMapping
	public User update(User user) {
		return userService.update(user);
	}

	/**
	 * 修改用户名
	 */
	@PatchMapping
	public User updateUsername(User user) {
		return userService.updateUsername(user);
	}

	/**
	 * 获取用户
	 */
	@GetMapping("{id}")
	public User get(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	/**
	 * 删除用户
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
}
