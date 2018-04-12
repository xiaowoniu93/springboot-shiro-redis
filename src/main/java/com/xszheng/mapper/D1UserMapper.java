package com.xszheng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xszheng.domain.D1User;

public interface D1UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d1_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d1_user
     *
     * @mbg.generated
     */
    int insert(D1User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d1_user
     *
     * @mbg.generated
     */
    int insertSelective(D1User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d1_user
     *
     * @mbg.generated
     */
    D1User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d1_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(D1User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table d1_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(D1User record);
    
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
}