package com.xszheng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xszheng.domain.D1User;
import com.xszheng.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 添加用户
	 * @author xszheng
	 * @date 2018年4月8日上午11:29:07
	 * @description
	 * @param
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public int addUser(@RequestBody D1User user) throws Exception{
		return userService.addUser(user);
	}

	/**
	 * 获取用户列表(分页)
	 * @author xszheng
	 * @date 2018年4月8日上午11:32:29
	 * @description
	 * @param
	 */
	@RequestMapping(value="list/{currentPage}/{pageSize}", method=RequestMethod.GET)
	public Object listUser(@PathVariable(name="currentPage") Integer currentPage, @PathVariable(name="pageSize") Integer pageSize) throws Exception{
		List<D1User> list = userService.listUser(currentPage, pageSize);
		return list;
	}
}
