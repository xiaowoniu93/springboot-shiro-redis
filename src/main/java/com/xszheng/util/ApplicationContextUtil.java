package com.xszheng.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {
	
	private static ApplicationContext appContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(null == appContext){
			appContext = applicationContext;
		}
	}
	
	/**
	 * 通过 name 获取bean
	 * @author xszheng
	 * @date 2018年4月12日上午11:05:29
	 * @description
	 * @param
	 */
	public static Object getBean(String name){
		return appContext.getBean(name);
	}
	
	/**
	 * 通过 classz 获取 bean 对象
	 * @author xszheng
	 * @date 2018年4月12日上午11:06:46
	 * @description
	 * @param
	 */
	public static <T> T getBean(Class<T> classz){
		return appContext.getBean(classz);
	}
}
