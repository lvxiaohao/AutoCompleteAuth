package com.xiniunet.surrounding.auth.domain;

import com.xiniunet.framework.base.Page;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
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
     * 应用名称
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

    public void addPage(String name) {
        if(pageList == null) {
            pageList = new ArrayList<Page>();
        }
        // FIXME
        pageList.add(new Page());
    }
}
