package com.xszheng.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xszheng.domain.D1User;


/**
 * 动态操作sql类，即增删改查所操作的表对象、表字段都是由入参决定的
 *
 * @author xiaosun.zheng
 */
public interface DynamicOperateMapper {

    /**
     * 添加指定表字段
     *
     * @param
     * @author xszheng
     * @date 2018年5月11日上午10:35:03
     * @description
     */
    void alterTableAddColumn(@Param(value = "tableName") String tableName, @Param(value = "columnSql") String columnSql);
    
    /**
     * 修改字段属性
     * @author xszheng
     * @date 2018年5月24日下午6:14:54
     * @description
     * @param
     */
    void alterTableModifyColumn(@Param(value="tableName") String tableName,
    							@Param(value="columnSql") String columnSql);
    
    
    /**
     * 修改字段名及属性
     * @author xszheng
     * @date 2018年5月24日下午6:18:34
     * @description
     * @param
     */
    void alterTableChangeColumn(@Param(value="tableName") String tableName,
    							@Param(value="oldColumnName") String oldColumnName,
    							@Param(value="columnSql") String columnSql);
    
    /**
     * 物理删除字段
     * @author xszheng
     * @date 2018年5月25日上午10:23:57
     * @description
     * @param
     */
    void alterTableDropColumn(@Param(value="tableName") String tableName,
    						  @Param(value="columnName") String columnName);
    
    
    /**
     * 物理删除表【DDL 语句 mysql底层不支持事务】
     * @author xszheng
     * @date 2018年5月25日下午3:24:06
     * @description
     * @param
     */
    void dropTable(@Param(value="tableName") String tableName);
    
}
