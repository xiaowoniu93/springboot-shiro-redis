package com.xszheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xszheng.domain.D1Resource;
import tk.mybatis.mapper.common.Mapper;

public interface D1ResourceMapper extends Mapper<D1Resource> {

	/**
     * 根据角色编号来获取相应的资源
     * @author xszheng
     * @date 2018年4月12日下午4:15:38
     * @description
     * @param
     */
    List<D1Resource> listByRoleNo(@Param(value="roleNo") String roleNo);
    
}