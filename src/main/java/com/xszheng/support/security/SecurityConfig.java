package com.xszheng.support.security;
//package com.dsdatas.cloud.config.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * Created by syq on 2016/12/7.
// */
//@Configuration
//@EnableWebSecurity//启用Security方法注解
//@EnableGlobalMethodSecurity(prePostEnabled = true)//启用Security方法注解
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    private CustomPasswordEncoder customPasswordEncoder;
//
//    @Autowired
//    private AuthenticationTokenFilter authenticationTokenFilter;
//
//    @Autowired
//    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
//
////    @Autowired
////    @Qualifier("corsFilter")
////    private Filter corsFilter;
//
//
////    @Autowired
////    private SimpleCORSFilter simpleCORSFilter;
//
//
//    @Autowired
//    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                // 设置UserDetailsService
//                .userDetailsService(this.customUserDetailsService)
//                // 使用MD5进行密码加密
//                .passwordEncoder(this.customPasswordEncoder);
//    }
//
//
//    /**
//     * Request层面的配置，对应XML Configuration中的<http>元素
//     * 这里只配置需要开放的接口url
//     *
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/user/login", "/admin/login", "/health", "/validImg/**", "/pcChangePwd",
//                        "/admin/**", "/contactUs/add", "/test/**", "/user/pcFindPwdSendSmsCode", "/api/token",
//                        "/v2/query", "/api/v1/query","/admin/channel/zuul/refresh", "/user/pcCheckSmsCode").permitAll()
//                .anyRequest().authenticated();
//        http.headers().cacheControl();
////        http.addFilterBefore(simpleCORSFilter, AuthenticationTokenFilter.class);
////        if (System.getenv("profile") == null || "dev".equals(System.getenv("profile"))) {
////            http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
////        }
////        if (System.getenv("profile") == null || "dev".equals(System.getenv("profile"))) {
////            System.out.println("本地环境加载跨域配置");
////            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
////            CorsConfiguration config = new CorsConfiguration();
////            config.setAllowCredentials(true);
////            config.addAllowedOrigin("*");
////            config.addAllowedHeader("*");
////            config.addAllowedMethod("*");
////            source.registerCorsConfiguration("/**", config);
////            Filter corsFilter = new CorsFilter(source);
////            http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);
////        }
//        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        http.exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint);
//    }
//
//
////    /**
////     * Web层面的配置，一般用来配置无需安全检查的路径
////     *
////     * @param web
////     * @throws Exception
////     */
////    @Override
////    public void configure(WebSecurity web) throws Exception {
//////        super.configure(web);
////        /*允许所有option的请求*/
////        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
////    }
//
//
//}
