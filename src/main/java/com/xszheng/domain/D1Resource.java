package com.xszheng.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="d1_resource")
public class D1Resource {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.id
     *
     * @mbg.generated
     */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.url
     *
     * @mbg.generated
     */
	@Column(name="url")
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.url_id
     *
     * @mbg.generated
     */
	@Column(name="url_id")
    private String urlId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.url_name
     *
     * @mbg.generated
     */
	@Column(name="url_name")
    private String urlName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.remark
     *
     * @mbg.generated
     */
	@Column(name="remark")
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.method_name
     *
     * @mbg.generated
     */
	@Column(name="method_name")
    private String methodName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column d1_resource.method_path
     *
     * @mbg.generated
     */
	@Column(name="method_path")
    private String methodPath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.id
     *
     * @return the value of d1_resource.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.id
     *
     * @param id the value for d1_resource.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.url
     *
     * @return the value of d1_resource.url
     *
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.url
     *
     * @param url the value for d1_resource.url
     *
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.url_id
     *
     * @return the value of d1_resource.url_id
     *
     * @mbg.generated
     */
    public String getUrlId() {
        return urlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.url_id
     *
     * @param urlId the value for d1_resource.url_id
     *
     * @mbg.generated
     */
    public void setUrlId(String urlId) {
        this.urlId = urlId == null ? null : urlId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.url_name
     *
     * @return the value of d1_resource.url_name
     *
     * @mbg.generated
     */
    public String getUrlName() {
        return urlName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.url_name
     *
     * @param urlName the value for d1_resource.url_name
     *
     * @mbg.generated
     */
    public void setUrlName(String urlName) {
        this.urlName = urlName == null ? null : urlName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.remark
     *
     * @return the value of d1_resource.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.remark
     *
     * @param remark the value for d1_resource.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.method_name
     *
     * @return the value of d1_resource.method_name
     *
     * @mbg.generated
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.method_name
     *
     * @param methodName the value for d1_resource.method_name
     *
     * @mbg.generated
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column d1_resource.method_path
     *
     * @return the value of d1_resource.method_path
     *
     * @mbg.generated
     */
    public String getMethodPath() {
        return methodPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column d1_resource.method_path
     *
     * @param methodPath the value for d1_resource.method_path
     *
     * @mbg.generated
     */
    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath == null ? null : methodPath.trim();
    }
}