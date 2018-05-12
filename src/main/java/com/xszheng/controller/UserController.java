package com.xszheng.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.xszheng.core.utils.JsonUtil;
import com.xszheng.domain.D1User;
import com.xszheng.domain.extend.UserExtend;
import com.xszheng.param.AddUserParam;
import com.xszheng.param.ListUserParam;
import com.xszheng.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/user")
@Api(value="用户模块入口")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	/**
	 * 登录
	 * @author xszheng
	 * @date 2018年4月12日下午2:28:57
	 * @description
	 * @param
	 */
	@ApiOperation(value="用户登录", notes = "用户登录")
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public JSON login(@RequestBody Map<String, String> params) throws Exception{
		UsernamePasswordAuthenticationToken upAuthToken = new UsernamePasswordAuthenticationToken(params.get("userName"), params.get("password"));
		Authentication authentication = authenticationManager.authenticate(upAuthToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		UserExtend eUser = (UserExtend) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("#UserController #login userName:"+eUser.getUserName());
		return JsonUtil.newJson().toJson();
	}
	
	/**
	 * 添加用户
	 * @author xszheng
	 * @date 2018年4月8日上午11:29:07
	 * @description
	 * @param
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public JSON addUser(@Valid @RequestBody AddUserParam param) throws Exception{
		log.info("#UserController #addUser userName="+param.getUserName());
		userService.addUser(param);
		return JsonUtil.newJson().toJson();
	}

	/**
	 * 获取用户列表(分页)
	 * @author xszheng
	 * @date 2018年4月8日上午11:32:29
	 * @description
	 * @param
	 */
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public JSON listUser(@RequestBody ListUserParam param) throws Exception{
		PageInfo<D1User> pageInfo = userService.listUser(param);
		return JsonUtil.newJson().addData("data", pageInfo.getList()).addPageInfo(pageInfo).toJson();
	}
	
	/**
	 * 测试
	 * @author xszheng
	 * @date 2018年4月12日上午11:35:21
	 * @description
	 * @param
	 */
	@RequestMapping(value="/getByNo", method=RequestMethod.GET)
	public JSON getUserByNo() throws Exception {
		UserExtend eUser = (UserExtend) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("#UserController #login userName:"+eUser.getUserName());
		UserExtend ue = new UserExtend();
		D1User user = ue.getUserByNo();
		return JsonUtil.newJson().addData("data", user).toJson();
	}
}
