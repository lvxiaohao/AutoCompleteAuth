package com.xiniunet.surrounding.auth.domain;

import com.xiniunet.framework.base.Page;
import com.xiniunet.surrounding.auth.constans.Constants;
import com.xiniunet.surrounding.auth.util.DictUtil;

import java.io.File;
import java.util.*;

/**
 * 产品对象.每一个web工程均为一个产品.
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
     * 生词字典
     */
    private Dict dict = new Dict();


    /**
     * 添加一个应用
     * @param application
     */
    public void addApplication(Application application) {

        File rootFile = new File(application.getFile(), Constants.FOLDER_SCREEN_LOCATION);
        if( ! rootFile.isDirectory()) {
            throw new RuntimeException("应用" + rootFile.getName() + "没有模板文件");
        }

        if(appList == null) {
            appList = new ArrayList<>();
        }
        appList.add(application);

        if(defaultAppName != null) {
            if(application.getName().equals(defaultAppName)) {
                application.setIsDefault(true);
            }
        }

        dealFolder(application, "", rootFile);
    }

    /**
     * 递归处理文件夹
     * @param application   文件夹所属的应用
     * @param baseUrl       当前文件夹的父级目录
     * @param rootFolder    当前文件夹
     */
    private void dealFolder(Application application,String baseUrl, File rootFolder) {

        File[] files = rootFolder.listFiles();
        if(files == null) {
            files = new File[0];
        }
        for(File tempFile : files) {
            String name = tempFile.getName();
            if(tempFile.isFile()) {
                if (name.endsWith(".vm")) {
                    name = name.replace(".vm", "");
                    Page page = application.addPage(baseUrl, name);
                    page.setProductCode(this.getCode());
                    page.setProduct(DictUtil.getValue(getDict(), "common.product.name"));

                    // 如果当前是默认应用,且设置了默认应用特殊处理
                    if(application.isDefault() && Constants.HOME_PAGE_SPECIAL_TREAMENT) {
                        page.setFunction(Constants.HOME_PAGE_FUNCTION);
                        page.setRecord(Constants.HOME_PAGE_RECORD);
                        page.setIdentity(Constants.HOME_PAGE_IDENTITY_CODE);
                    } else {
                        page.setApplicationCode(this.getCode() + "." + application.getName());
                        page.setApplication(DictUtil.getValue(getDict(), "app." + application.getName()));

                        page.setIdentity(Constants.PAGE_IDENTITY_CODE);
                        page.setRecord(Constants.PAGE_RECORD);

                        String[] nameSections = page.getUrl().replace(".vm", "").split("/");
                        if(nameSections.length == 1) {
                            page.setDescription(page.getProduct() + "-" + DictUtil.getValue(getDict(), "page."+nameSections[0]));

                            // FIXME page.setFunction()
                        } else if (nameSections.length == 2) {
                            page.setDescription(page.getApplication() + "-" + DictUtil.getValue(getDict(), "page."+nameSections[0]));

                            if (name.equalsIgnoreCase("index") && !Constants.PAGE_INDEX_HAS_FUNCTION) {
                                page.setFunction("logged");
                            } else if (name.equalsIgnoreCase("setting") && !Constants.PAGE_SETTING_HAS_FUNCTION) {
                                page.setFunction("logged");
                            } else if (name.equalsIgnoreCase("report") && !Constants.PAGE_REPORT_HAS_FUNCTION) {
                                page.setFunction("logged");
                            }
                            // FIXME page.setFunction()


                        } else if (nameSections.length > 2) {
                            StringBuilder stringBuilder = new StringBuilder(page.getApplication());
                            stringBuilder.append("-");
                            int i=1;
                            for(; i<nameSections.length-1; i++) {
                                stringBuilder.append(DictUtil.getValue(getDict(), "folder."+nameSections[i])).append("-");
                            }
                            stringBuilder.append(DictUtil.getValue(getDict(), "page."+nameSections[i]));
                            page.setDescription(stringBuilder.toString());

                            // 如果二级目录为报表目录
                            if (nameSections[1].equalsIgnoreCase(Constants.FOLDER_REPORT_NAME)) {
                                page.setFunction(application.getName() + "." + name + ".report");
                            } else if (nameSections[1].equalsIgnoreCase(Constants.FOLDER_SETTING_NAME)) {

                                //如果二级目录为设置目录
                                page.setFunction(application.getName() + "." + name + ".setting");
                            }else {

                                // 其它情况下
                                page.setFunction(application.getName() + "." + nameSections[1] + ".manage");
                            }
                        }
                    }
                    System.out.println(page.getFunction());
                }
            } else {

                // 递归调用
                dealFolder(application, baseUrl + "/" + tempFile.getName(), tempFile);
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
