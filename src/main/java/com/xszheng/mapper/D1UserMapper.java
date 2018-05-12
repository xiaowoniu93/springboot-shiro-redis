package com.xszheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xszheng.domain.D1User;
import tk.mybatis.mapper.common.Mapper;

public interface D1UserMapper extends Mapper<D1User> {
	
	/**
     * 获取用户列表
     * @author xszheng
     * @date 2018年4月8日上午11:22:51
     * @description
     * @param
     */
    List<D1User> listUser();
    
    /**
     * 根据userNo 查询对象
     * @author xszheng
     * @date 2018年4月12日上午11:10:23
     * @description
     * @param
     */
    D1User getUserByNo(@Param(value="userNo") String userNo);
    
    /**
     * 根据userName 查询对象
     * @author xszheng
     * @date 2018年4月12日上午11:10:23
     * @description
     * @param
     */
    D1User getUserByName(@Param(value="userName") String userName);
    
}