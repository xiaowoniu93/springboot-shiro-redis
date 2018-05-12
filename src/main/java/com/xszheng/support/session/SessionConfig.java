package com.xszheng.support.session;

import org.springframework.context.annotation.Bean;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * 分布式Session，使用spring.session.store-type=redis自动配置
 * @author xszheng
 *
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds=1800)
public class SessionConfig {

	@Bean
	public HttpSessionStrategy httpSessionStrategy(){
		return new HeaderHttpSessionStrategy();
	}
}
