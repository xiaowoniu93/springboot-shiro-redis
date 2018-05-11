package com.xszheng.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "d1_resource_role")
public class D1ResourceRole {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色编号
     */
    @Column(name = "role_no")
    private String roleNo;

    /**
     * 资源ID
     */
    @Column(name = "url_id")
    private String urlId;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取资源ID
     *
     * @return url_id - 资源ID
     */
    public String getUrlId() {
        return urlId;
    }

    /**
     * 设置资源ID
     *
     * @param urlId 资源ID
     */
    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}