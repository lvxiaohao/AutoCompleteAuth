package com.xiniunet.surrounding.auth.domain;

import com.xiniunet.surrounding.auth.constans.Constants;

import java.io.File;
import java.util.*;

/**
 * Created on 2015-05-11.
 * AutoCompleteAuth
 *
 * @author 小昊
 * @since 1.0.0
 */
public class Product {

    /**
     * 项目名称
     */
    private String name;

    /**
     * 产品代码
     */
    private String code;

    /**
     * 默认应用名称
     */
    private String defaultAppName;

    /**
     * 项目下的应用列表.
     */
    private List<Application> appList;

    /**
     * 项目内字典
     */
    private Dict dict = new Dict();


    public void addApplication(Application application) {

        File rootFile = new File(application.getFile(), Constants.SCREEN_LOCATION);
        if( ! rootFile.isDirectory()) {
            throw new RuntimeException("应用" + rootFile.getName() + "没有模板文件");
        }

        if(appList == null) {
            appList = new ArrayList<>();
        }
        appList.add(application);
        dict.addWord(Dict.Type.APP, application.getName(), application.getName());

        if(defaultAppName != null) {
            if(application.getName().equals(defaultAppName)) {
                application.setIsDefault(true);
            }
        }

        dealFolder(application, rootFile);
    }

    private void dealFolder(Application application, File rootFolder) {

        File[] files = rootFolder.listFiles();
        if(files == null) {
            files = new File[0];
        }
        for(File tempFile : files) {
            String name = tempFile.getName();
            if(tempFile.isFile()) {
                if (name.endsWith(".vm")) {
                    application.addPage(name);

                    // 添加单词
                    dict.addWord(Dict.Type.PAGE, tempFile);
                }
            } else {
                // 添加单词
                dict.addWord(Dict.Type.FOLDER, tempFile);

                // 递归调用
                dealFolder(application, tempFile);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefaultAppName() {
        return defaultAppName;
    }

    public void setDefaultAppName(String defaultAppName) {
        this.defaultAppName = defaultAppName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Application> getAppList() {
        return appList;
    }

    public void setAppList(List<Application> appList) {
        this.appList = appList;
    }

    public Dict getDict() {
        return dict;
    }

    public void setDict(Dict dict) {
        this.dict = dict;
    }
}
