package com.xszheng.domain;

import javax.persistence.*;

@Table(name = "d1_resource")
public class D1Resource {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 资源ID
     */
    @Column(name = "url_id")
    private String urlId;

    /**
     * 资源名称
     */
    @Column(name = "url_name")
    private String urlName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 资源对应的方法名
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 资源对应的包路径
     */
    @Column(name = "method_path")
    private String methodPath;

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
     * 获取资源路径
     *
     * @return url - 资源路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源路径
     *
     * @param url 资源路径
     */
    public void setUrl(String url) {
        this.url = url;
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
     * 获取资源名称
     *
     * @return url_name - 资源名称
     */
    public String getUrlName() {
        return urlName;
    }

    /**
     * 设置资源名称
     *
     * @param urlName 资源名称
     */
    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取资源对应的方法名
     *
     * @return method_name - 资源对应的方法名
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置资源对应的方法名
     *
     * @param methodName 资源对应的方法名
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * 获取资源对应的包路径
     *
     * @return method_path - 资源对应的包路径
     */
    public String getMethodPath() {
        return methodPath;
    }

    /**
     * 设置资源对应的包路径
     *
     * @param methodPath 资源对应的包路径
     */
    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }
}