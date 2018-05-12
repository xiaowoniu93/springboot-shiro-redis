package com.xszheng.param;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class AddUserParam {
	
	@NotBlank(message="用户名不能为空")
	private String userName;
	
	@NotBlank(message="密码不能为空")
	private String password;
	
	@NotBlank(message="手机号不能为空")
	private String phone;

}
