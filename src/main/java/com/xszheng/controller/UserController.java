package com.xszheng.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xszheng.domain.D1User;
import com.xszheng.param.AddUserParam;
import com.xszheng.param.ListUserParam;
import com.xszheng.service.UserService;
import com.xszheng.util.JsonUtil;

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
	public JSON addUser(@Valid @RequestBody AddUserParam param, BindingResult result) throws Exception{
		log.info("#UserController #addUser userName="+param.getUserName());
		int r = userService.addUser(param);
		return JsonUtil.newJson().toJson();
	}

	/**
	 * 获取用户列表(分页)
	 * @author xszheng
	 * @date 2018年4月8日上午11:32:29
	 * @description
	 * @param
	 */
	@RequestMapping(value="list", method=RequestMethod.POST)
	public Object listUser(@RequestBody ListUserParam param) throws Exception{
		PageInfo<D1User> pageInfo = userService.listUser(param);
		return JsonUtil.newJson().addData("data", pageInfo.getList()).addPageInfo(pageInfo).toJson();
	}
}
