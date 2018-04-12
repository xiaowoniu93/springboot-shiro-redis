package com.xszheng.service;

import com.github.pagehelper.PageInfo;
import com.xszheng.domain.D1User;
import com.xszheng.param.AddUserParam;
import com.xszheng.param.ListUserParam;

public interface UserService {
	
	// 添加单个用户
	int addUser(AddUserParam param) throws Exception;
	
	// 获取用户列表(分页)
	PageInfo<D1User> listUser(ListUserParam param) throws Exception;
	
	/**
	 * 根据userNo 查询对象
	 * @author xszheng
	 * @date 2018年4月12日上午11:09:06
	 * @description
	 * @param
	 */
	D1User getUserByNo(String userNo) throws Exception;

}
