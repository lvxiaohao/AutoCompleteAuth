package com.xiniunet.surrounding.auth.domain;


import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Web应用中的一个目录.
 * Created on 2014/12/3.
 *
 * @author 吕浩
 * @version 1.0.0
 */
@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog extends Page {

	private Map<String, Catalog> catalogMap = new HashMap<>();

	private Map<String, Page> pageMap = new HashMap<>();

	/**
	 * 基础目录（两端不要出现"/")
	 */
	@XmlAttribute
	private String baseUrl;

	/**
	 * 该目录包含的页面列表
	 */
	@XmlElement(name = "page")
	private List<Page> pages = new ArrayList<>();

	/**
	 * 子目录列表
	 */
	@XmlElement(name = "catalog")
	private List<Catalog> catalogs = new ArrayList<>();

	/**
	 * 添加一个目录
	 * @param catalog
	 */
	public void addCatalog(Catalog catalog) {
		catalogs.add(catalog);
		catalogMap.put(catalog.getBaseUrl(), catalog);
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public List<Page> getPages() {
		return pages;
	}

	public void setPages(List<Page> pages) {
		this.pages = pages;
		pageMap.clear();

		if(pages != null) {
			for(Page page : pages) {
				pageMap.put(page.getUrl(), page);
			}
		}
	}

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
		catalogMap.clear();

		if(catalogs != null) {
			for(Catalog catalog : catalogs) {
				catalogMap.put(catalog.getBaseUrl(), catalog);
			}
		}
	}

	@Override
	public String toString() {
		return "Catalog{" +
				"pages=" + pages +
				"catalogs=" + catalogs +
				'}';
	}
}
