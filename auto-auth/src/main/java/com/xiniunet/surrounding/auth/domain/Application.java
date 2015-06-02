package com.xiniunet.surrounding.auth.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用(模块)对象.每一个web工程均包含至少一个应用.
 * Created on 2015-05-11.
 * AutoCompleteAuth
 *
 * @author 小昊
 * @since 1.0.0
 */
public class Application {
    /**
     * 应用目录
     */
    private File file;
    /**
     * 应用名称(文件夹对应的英文名称)
     */
    private String name;
    /**
     * 应用代码
     */
    private String code;
    /**
     * 是否为默认应用
     */
    private boolean isDefault;
    /**
     * 应用下的页面列表
     */
    private List<Page> pageList;

    public Application(File rootFile) {
        this.file = rootFile;
        this.name = rootFile.getName();
    }

    /**
     * 为应用添加一个页面.
     * @param baseUrl   页面的父目录
     * @param name      页面的名称
     * @return          新添加的页面.
     */
    public Page addPage(String baseUrl, String name) {
        if(pageList == null) {
            pageList = new ArrayList<>();
        }

        // 拼出当前页面的url
        StringBuilder url = new StringBuilder();

        // 默认应用的页面,直接进行访问,不需要使用应用名称作为父级目录
        // 如果不是默认应用的页面,则应该在路径的前面添加应用的名称来访问.
        if(!this.isDefault()) {
            url.append(this.getName());
        }

        if(baseUrl == null || baseUrl.isEmpty()) {
            // 避免默认应用下的页面路径以"/"开关
            if(url.length()>0) {
                url.append("/");
            }
        } else {
            if(!baseUrl.startsWith("/")) {
                url.append("/");
            }
            url.append(baseUrl);
            if(!baseUrl.endsWith("/")) {
                url.append("/");
            }
        }
        url.append(name);

        Page page = new Page();
        // 此时只保存url属性,其余属性在其它地方设置
        page.setUrl(url.toString());
        pageList.add(page);
        return page;
    }

    // ------ getter && setter ------

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }
}
