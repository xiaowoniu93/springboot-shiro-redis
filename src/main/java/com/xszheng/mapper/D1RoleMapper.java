package com.xszheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xszheng.domain.D1Role;
import tk.mybatis.mapper.common.Mapper;

public interface D1RoleMapper extends Mapper<D1Role> {
	/**
     * 根据用户编号查询所有角色
     * @author xszheng
     * @date 2018年4月12日下午1:15:51
     * @description
     * @param
     */
    List<D1Role> listRolesByUserNo(@Param(value="userNo") String userNo);
    
    /**
     * 获取所有角色
     * @author xszheng
     * @date 2018年4月12日下午4:03:31
     * @description
     * @param
     */
    List<D1Role> listAll();
    
}