package com.xszheng.spsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.xszheng.domain.D1Role;
import com.xszheng.domain.D1User;
import com.xszheng.domain.extend.UserExtend;
import com.xszheng.service.RoleService;
import com.xszheng.service.impl.RoleServiceImpl;
import com.xszheng.util.ApplicationContextUtil;

public class SecurityUser extends UserExtend implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1468751732676497097L;
	
	public SecurityUser(D1User user){
		if(user != null){
			RoleService roleService = ApplicationContextUtil.getBean(RoleServiceImpl.class);
			this.setId(user.getId());
			this.setUserNo(user.getUserNo());
			this.setUserName(user.getUserName());
			this.setPassword(user.getPassword());
			this.setPhone(user.getPhone());
			try {
				this.setRoles(roleService.listRolesByUserNo(user.getUserNo()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		List<D1Role> roles = this.getRoles();
		if(roles != null){
			for(D1Role role : roles){
				SimpleGrantedAuthority sgauth = new SimpleGrantedAuthority(role.getRoleNo());
				authorities.add(sgauth);
			}
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
