package com.xszheng.domain.extend;

import java.util.List;

import com.xszheng.domain.D1Role;
import com.xszheng.domain.D1User;
import com.xszheng.service.UserService;
import com.xszheng.service.impl.UserServiceImpl;
import com.xszheng.util.ApplicationContextUtil;

public class UserExtend extends D1User {
	
	private List<D1Role> roles;

	public List<D1Role> getRoles() {
		return roles;
	}

	public void setRoles(List<D1Role> roles) {
		this.roles = roles;
	}
	
	public D1User getUserByNo() throws Exception{
		UserService userService = ApplicationContextUtil.getBean(UserServiceImpl.class);
		D1User user = userService.getUserByNo("UN1128601035");
		return user;
	}
}
