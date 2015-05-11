package com.xiniunet.framework.base;

import java.util.List;

/**
 * Created on 2014/12/5.
 *
 * @author 吕浩
 * @version 1.0.0
 */
public class Root extends Catalog {
	private List<Catalog> catalogs;

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}
}
