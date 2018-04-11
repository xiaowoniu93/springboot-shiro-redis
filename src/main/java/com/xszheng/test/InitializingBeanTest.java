package com.xszheng.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class InitializingBeanTest implements InitializingBean {

	/**
	 * 该类如果是个bean，项目启动就会加载该方法
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.err.println("InitializingBean Test, afterPropertiesSet()");
	}

}
