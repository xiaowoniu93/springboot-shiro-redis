package com.xszheng.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xszheng.constant.CacheNameConstant;
import com.xszheng.domain.D1User;
import com.xszheng.mapper.D1UserMapper;
import com.xszheng.param.AddUserParam;
import com.xszheng.param.ListUserParam;
import com.xszheng.service.UserService;
import com.xszheng.util.NoGenerator;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private D1UserMapper d1UserMapper;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	@CacheEvict(value=CacheNameConstant.CACHE_NAME_1, allEntries=true)
	public int addUser(AddUserParam param) throws Exception {
		D1User user = new D1User();
		BeanUtils.copyProperties(user, param);
		user.setUserNo(NoGenerator.getUserNo());
		int r = d1UserMapper.insertSelective(user);
		return r;
	}

	@Override
	@Cacheable(value=CacheNameConstant.CACHE_NAME_1, key="'user'+#param.getCurrentPage()+#param.getPageSize()")
	public PageInfo<D1User> listUser(ListUserParam param) throws Exception {
		System.err.println("查询数据库");
		log.info("key=mykey:"+stringRedisTemplate.opsForValue().get("mykey"));
		stringRedisTemplate.opsForValue().set("testKey", "testValue", 60, TimeUnit.SECONDS);
		PageHelper.startPage(param.getCurrentPage(), param.getPageSize());
		List<D1User> list = d1UserMapper.listUser();
		PageInfo<D1User> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public D1User getUserByNo(String userNo) throws Exception {
		D1User user = d1UserMapper.getUserByNo(userNo);
		return user;
	}

	@Override
	public D1User getUserByName(String userName) throws Exception {
		return null;
	}
	
}
