package com.xszheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xszheng.domain.D1Role;
import com.xszheng.mapper.D1RoleMapper;
import com.xszheng.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private D1RoleMapper roleMapper;
	
	@Override
	public List<D1Role> listRolesByUserNo(String userNo) throws Exception {
		List<D1Role> roles = roleMapper.listRolesByUserNo(userNo);
		return roles;
	}

}
