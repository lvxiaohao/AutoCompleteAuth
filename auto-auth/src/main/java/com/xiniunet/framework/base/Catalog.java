package com.xiniunet.framework.base;


import java.util.List;

/**
 * Web应用中的一个目录.
 * Created on 2014/12/3.
 *
 * @author 吕浩
 * @version 1.0.0
 */
public class Catalog extends Page {

	/**
	 * 基础目录（两端不要出现"/")
	 */
	private String baseUrl;

	/**
	 * 该目录包含的页面列表
	 */
	private List<Page> pages;

	private List<Catalog> catalogs;

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
	}

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	@Override
	public String toString() {
		return "Catalog{" +
				"pages=" + pages +
				"catalogs=" + catalogs +
				'}';
	}
}
