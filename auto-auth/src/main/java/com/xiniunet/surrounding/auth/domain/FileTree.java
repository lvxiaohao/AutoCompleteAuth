package com.xiniunet.surrounding.auth.domain;

import javax.xml.bind.annotation.*;
import java.util.*;

/**
 * Created on 2014/12/5.
 *
 * @author 吕浩
 * @version 1.0.0
 */
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class FileTree extends Catalog {

	private Map<String, Catalog> catalogMap = new HashMap<>();

	/**
	 * 项目下的目录列表
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

	/**
	 * 通过目录的名称获取一个目录对象
	 * @param baseUrl
	 * @return
	 */
	public Catalog getCatalog(String baseUrl) {
		return catalogMap.get(baseUrl);
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
}
