package com.xiniunet.surrounding.auth.util;

import com.xiniunet.framework.base.Catalog;
import com.xiniunet.framework.base.Root;
import com.xiniunet.surrounding.auth.domain.Application;
import com.xiniunet.surrounding.auth.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2015-05-14.
 * AutoCompleteAuth
 *
 * @author 小昊
 * @since 1.0.0
 */
public class FunctioinUtil {
    /**
     * 根据项目里的内容生成pages.xml
     * @param product   要生成pages.xml文件的项目
     */
    public static void generatePageXml(Product product) {
        Root root = new Root();
        List<Catalog> catalogList = new ArrayList<>();
        Catalog catalog = new Catalog();
        catalogList.add(catalog);
        root.setCatalogs(catalogList);

        for(Application application : product.getAppList()) {
            catalog.getPages().addAll(application.getPageList());
        }

    }
}
