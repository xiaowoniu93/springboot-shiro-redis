package com.xszheng.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.xszheng.domain.D1User;
import com.xszheng.param.AddUserParam;
import com.xszheng.param.ListUserParam;
import com.xszheng.service.UserService;

@Service(value="newUserService")
public class NewUserServiceImpl implements UserService {

	@Override
	public int addUser(AddUserParam param) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<D1User> listUser(ListUserParam param) throws Exception {
		System.out.println("NewUserServiceImpl listUser()....");
		return new PageInfo<>(new ArrayList<>());
	}

	@Override
	public D1User getUserByNo(String userNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public D1User getUserByName(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void testTransactional(Long id) throws Exception {
		// TODO Auto-generated method stub

	}

}
