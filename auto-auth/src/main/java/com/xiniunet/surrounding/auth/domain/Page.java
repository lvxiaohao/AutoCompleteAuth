package com.xiniunet.surrounding.auth.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 权限控制所用到的页面对象
 * Created on 2014/8/17.
 * @author 吕浩
 * @version 0.1.0
 */
@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page implements Serializable {
	/**
	 * 该页面对应的URL
	 */
	@XmlAttribute
	private String url;

	/**
	 * 该页面的描述信息
	 */
	@XmlAttribute
	private String description;

	/**
	 * 该页面所属产品名称
	 */
	@XmlAttribute
	private String product;

	/**
	 * 产品的code
	 */
	@XmlAttribute
	private String productCode;

	/**
	 * 该页面所属应用名称
	 */
	@XmlAttribute
	private String application;

	/**
	 * 应用的code
	 */
	@XmlAttribute
	private String applicationCode;

	/**
	 * 该页面所属功能点
	 */
	@XmlAttribute
	private String function;

	/**
	 * 该页面的身份
	 */
	@XmlAttribute
	private String identity;

	/**
	 * 日志系统是否记录该页面。
	 */
	@XmlAttribute
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
				", application='" + application + '\'' +
				", function='" + function + '\'' +
				", identity='" + identity + '\'' +
				", record=" + record +
				'}';
	}
}
