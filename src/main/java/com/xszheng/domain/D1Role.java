package com.xszheng.domain;

import javax.persistence.*;

@Table(name = "d1_role")
public class D1Role {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户号
     */
    @Column(name = "user_no")
    private String userNo;

    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

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
     * 获取用户号
     *
     * @return user_no - 用户号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户号
     *
     * @param userNo 用户号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取角色编号
     *
     * @return role_no - 角色编号
     */
    public String getRoleNo() {
        return roleNo;
    }

    /**
     * 设置角色编号
     *
     * @param roleNo 角色编号
     */
    public void setRoleNo(String roleNo) {
        this.roleNo = roleNo;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}