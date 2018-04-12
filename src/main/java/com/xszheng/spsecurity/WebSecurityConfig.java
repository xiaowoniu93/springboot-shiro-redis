package com.xszheng.spsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService userDetailService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user/getByNo").permitAll()	// 该 matches 的URL无需鉴权
			.anyRequest().authenticated()	// 其他URL都需鉴权
			.and()
			.formLogin().loginProcessingUrl("/user/login").permitAll()	// 指定登录地址为 /user/login
			.successHandler(loginSuccessHandler())	// 登录成功后使用该方法来存储用户信息
			.and()
			.logout().logoutUrl("/user/logOut").permitAll().invalidateHttpSession(true);	// 指定退出地址并销毁session
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailService);
	}

	@Bean
	public LoginSuccessHandler loginSuccessHandler(){
		return new LoginSuccessHandler();
	}
}
