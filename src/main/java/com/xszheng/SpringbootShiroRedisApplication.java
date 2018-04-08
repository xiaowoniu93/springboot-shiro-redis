package com.xszheng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xszheng.mapper")	//将项目中对应的mapper类的路径
public class SpringbootShiroRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootShiroRedisApplication.class, args);
	}

}
