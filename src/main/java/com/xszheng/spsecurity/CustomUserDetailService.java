package com.xszheng.spsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.xszheng.domain.D1User;
import com.xszheng.service.UserService;

@Component
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SecurityUser sUser = null;
		D1User user = null;
		try {
			user = userService.getUserByName(userName);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(null == user){
			throw new UsernameNotFoundException("userName:"+userName+" 不存在！");
		}
		sUser = new SecurityUser(user);
		return sUser;
	}

}
