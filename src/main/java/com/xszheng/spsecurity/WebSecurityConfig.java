package com.xszheng.spsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailService userDetailService;
	
	@Autowired
	private MySecurityInterceptor securityInterceptor;
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(securityInterceptor, FilterSecurityInterceptor.class).csrf().disable()	// 加载过滤器，关闭 csrf 认证
			.authorizeRequests()
			.antMatchers("/user/getByNo").permitAll()	// 该 matches 的URL无需鉴权
			.anyRequest().authenticated()	// 其他URL都需鉴权
			.and()
			.formLogin().loginProcessingUrl("/user/login").permitAll()	// 指定登录地址为 /user/login
			.successHandler(loginSuccessHandler())	// 登录成功后使用该方法来存储用户信息
			.and()
			.logout().logoutUrl("/user/logOut").permitAll().invalidateHttpSession(true);	// 指定退出地址并销毁session
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		super.configure(web);
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
