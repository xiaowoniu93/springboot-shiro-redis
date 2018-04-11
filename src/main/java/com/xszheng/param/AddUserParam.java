package com.xszheng.param;

import org.hibernate.validator.constraints.NotBlank;

public class AddUserParam {
	
	@NotBlank(message="用户名不能为空")
	private String userName;
	
	@NotBlank(message="密码不能为空")
	private String password;
	
	private String phone;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
