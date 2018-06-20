package com.xszheng.domain;

import javax.persistence.*;

@Table(name = "d1_user")
public class D1User {
    /**
     * 主键
     */
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator="JDBC")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户No
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 状态：-1-锁定，1-正常
     */
    private Boolean status;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户No
     *
     * @return user_no - 用户No
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户No
     *
     * @param userNo 用户No
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取状态：-1-锁定，1-正常
     *
     * @return status - 状态：-1-锁定，1-正常
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态：-1-锁定，1-正常
     *
     * @param status 状态：-1-锁定，1-正常
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }
}