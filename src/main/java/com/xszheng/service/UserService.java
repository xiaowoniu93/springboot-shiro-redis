package com.xszheng.service;

import java.util.List;

import com.xszheng.domain.D1User;

public interface UserService {
	
	// 添加单个用户
	int addUser(D1User user) throws Exception;
	
	// 获取用户列表(分页)
	List<D1User> listUser(int currentPage, int pageSize) throws Exception;

}
