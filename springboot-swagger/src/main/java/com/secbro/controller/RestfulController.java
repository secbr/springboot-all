package com.secbro.controller;

import com.secbro.entity.User;
import com.secbro.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sec
 * @version 1.0
 * @date 2020/2/19 10:17 AM
 **/
@Api(value = "用户管理接口", tags = "用户操作")
@RestController
@RequestMapping("/user")
public class RestfulController {

	@Resource
	private UserService userService;

	/**
	 * 创建用户操作
	 */
	@ApiOperation(value = "创建用户", tags = "新增", notes = "此结构仅限：用户注册用户场景")
	@PostMapping
	public User addUser(User user) {
		return userService.addUser(user);
	}

	/**
	 * 获取所需用户操作
	 */
	@ApiOperation(value = "查询所有用户", tags = "查询")
	@GetMapping("/list")
	public List<User> listUser() {
		return userService.findAll();
	}

	/**
	 * 更新用户
	 */
	@ApiOperation(value = "更新用户", tags = "更新")
	@PutMapping
	public User update(User user) {
		return userService.update(user);
	}

	/**
	 * 修改用户名
	 */
	@ApiOperation(value = "修改用户名", tags = "更新")
	@PatchMapping
	public User updateUsername(User user) {
		return userService.updateUsername(user);
	}

	/**
	 * 获取用户
	 */
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", defaultValue = "0",
			example = "0")
	@ApiOperation(value = "根据ID查询用户", tags = "查询")
	@GetMapping("{id}")
	public User get(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	/**
	 * 删除用户
	 */
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id",
					value = "用户ID",
					paramType = "path",
					required = true,
					dataType = "Long",
					defaultValue = "0",
					example = "0"),
			@ApiImplicitParam(name = "remark", value = "备注")
	})
	@ApiOperation(value = "根据ID删除用户", tags = "删除")
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
}
