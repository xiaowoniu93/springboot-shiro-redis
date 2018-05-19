package com.xszheng.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.github.pagehelper.PageInterceptor;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
@ComponentScan(value = "com.xszheng.mapper")
public class MyBatisMapperConfig {
	@Bean
	public MapperScannerConfigurer masterMapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.xszheng.mapper");
		Properties properties = new Properties();
		properties.setProperty("mappers",
				"tk.mybatis.mapper.common.Mapper,tk.mybatis.mapper.common.MySqlMapper,tk.mybatis.mapper.common.IdsMapper");
		properties.setProperty("notEmpty", "false");
		properties.setProperty("ORDER", "BEFORE");
		mapperScannerConfigurer.setProperties(properties);
		return mapperScannerConfigurer;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
		sfb.setDataSource(dataSource);
		/*sfb.setTypeAliasesPackage("com.uama.microservices.provider.*.model");*/
		org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
		config.setLogImpl(Slf4jImpl.class);
		config.setCallSettersOnNulls(true);
		sfb.setConfiguration(config);

		// 分页插件
		PageInterceptor pageInterceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "false");
		properties.setProperty("helperDialect", "mysql");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		properties.setProperty("autoRuntimeDialect", "true");
		pageInterceptor.setProperties(properties);

		// 添加插件
		sfb.setPlugins(new Interceptor[] { pageInterceptor });

		return sfb.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(@Autowired SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(@Autowired DataSource dataSource) {
		DataSourceTransactionManager dstm = new DataSourceTransactionManager(dataSource);
		dstm.setNestedTransactionAllowed(true);
		return dstm;
	}
}
