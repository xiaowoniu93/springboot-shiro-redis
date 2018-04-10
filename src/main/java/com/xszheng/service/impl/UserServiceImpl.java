package com.xszheng.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xszheng.constant.CacheNameConstant;
import com.xszheng.domain.D1User;
import com.xszheng.mapper.D1UserMapper;
import com.xszheng.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private D1UserMapper d1UserMapper;
	
//	@Autowired
//	private RedisTemplate redisTempalte;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Override
	@CacheEvict(value=CacheNameConstant.CACHE_NAME_1, allEntries=true)
	public int addUser(D1User user) throws Exception {
		int r = d1UserMapper.insertSelective(user);
		return r;
	}

	@Override
	@Cacheable(value=CacheNameConstant.CACHE_NAME_1, key="'user'+#currentPage+#pageSize")
	public List<D1User> listUser(int currentPage, int pageSize) throws Exception {
		System.err.println("查询数据库");
		log.info("key=mykey:"+stringRedisTemplate.opsForValue().get("mykey"));
		PageHelper.startPage(currentPage, pageSize);
		List<D1User> list = d1UserMapper.listUser();
		return list;
	}
	
}
