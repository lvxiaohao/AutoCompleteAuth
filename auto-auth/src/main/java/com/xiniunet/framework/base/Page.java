package com.xiniunet.framework.base;

import java.io.Serializable;

/**
 * 权限控制所用到的页面对象
 * Created on 2014/8/17.
 * @author 吕浩
 * @version 0.1.0
 */
public class Page implements Serializable {
	/**
	 * 该页面对应的URL
	 */
	private String url;

	/**
	 * 该页面的描述信息
	 */
	private String description;

	/**
	 * 该页面所属产品名称
	 */
	private String product;

	/**
	 * 产品的ID
	 */
	private Long productId;

	/**
	 * 产品的code
	 */
	private String productCode;

	/**
	 * 该页面所属应用名称
	 */
	private String application;

	/**
	 * 应用的ID
	 */
	private Long applicationId;

	/**
	 * 应用的code
	 */
	private String applicationCode;

	/**
	 * 该页面所属功能点
	 */
	private String function;

	/**
	 * 该页面的身份
	 */
	private String identity;

	/**
	 * 日志系统是否记录该页面。
	 */
	private Boolean record;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public Boolean getRecord() {
		return record;
	}

	public void setRecord(Boolean record) {
		this.record = record;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	@Override
	public String toString() {
		return "Page{" +
				"url='" + url + '\'' +
				", description='" + description + '\'' +
				", product='" + product + '\'' +
				", productId=" + productId +
				", application='" + application + '\'' +
				", applicationId=" + applicationId +
				", function='" + function + '\'' +
				", identity='" + identity + '\'' +
				", record=" + record +
				'}';
	}
}
