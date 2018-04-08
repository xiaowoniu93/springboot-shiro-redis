package com.xszheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xszheng.domain.D1User;
import com.xszheng.mapper.D1UserMapper;
import com.xszheng.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private D1UserMapper d1UserMapper;

	@Override
	public int addUser(D1User user) throws Exception {
		int r = d1UserMapper.insertSelective(user);
		return r;
	}

	@Override
	public List<D1User> listUser(int currentPage, int pageSize) throws Exception {
		PageHelper.startPage(currentPage, pageSize);
		List<D1User> list = d1UserMapper.listUser();
		return list;
	}
	
}
