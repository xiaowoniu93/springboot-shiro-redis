package com.xszheng.service;

import java.util.List;

import com.xszheng.domain.D1Role;

public interface RoleService {
	
	public List<D1Role> listRolesByUserNo(String userNo) throws Exception;
}
