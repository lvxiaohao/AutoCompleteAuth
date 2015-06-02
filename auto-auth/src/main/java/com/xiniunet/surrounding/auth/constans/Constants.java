package com.xiniunet.surrounding.auth.constans;

/**
 * Created on 2015-05-11.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class Constants {
    /**
     * 项目路径
     */
    public static String PROJECT_URL;

    /**
     * 产品代码
     */
    public static String PROJECT_CODE;

    /**
     * 应用所在目录
     */
    public static final String FOLDER_APPS = "/src/main/webapp";
    /**
     * 配置文件所在目录
     */
    public static final String FOLDER_WEB_INFO = FOLDER_APPS + "/WEB-INF";
    /**
     * webx.xml配置文件所在目录
     */
    public static final String FILE_DEFAULT_WEBX_XML = FOLDER_WEB_INFO + "/webx.xml";

    /**
     * 应用内screen目录的相对路径
     */
    public static final String FOLDER_SCREEN_LOCATION = "templates/screen";
    /**
     * 应用内报表目录名称
     */
    public static final String FOLDER_REPORT_NAME = "report";
    /**
     * 应用内设置目录名称
     */
    public static final String FOLDER_SETTING_NAME = "setting";


    public static final Boolean HOME_PAGE_SPECIAL_TREATMENT = true;
    /**
     * 公共页面默认身份
     */
    public static final String HOME_PAGE_IDENTITY_CODE = "all";
    /**
     * 公共页面默认记录规则
     */
    public static final Boolean HOME_PAGE_RECORD = false;
    /**
     * 公共页面默认功能点
     */
    public static final String HOME_PAGE_FUNCTION = "all";


    /**
     * 页面默认身份
     */
    public static final String PAGE_IDENTITY_CODE = "employee || none";
    /**
     * 页面默认记录规则
     */
    public static final Boolean PAGE_RECORD = true;

    /**
     * index页面是否分配功能点
     */
    public static final Boolean PAGE_INDEX_HAS_FUNCTION = false;
    /**
     * setting页面是否分配功能点
     */
    public static final Boolean PAGE_SETTING_HAS_FUNCTION = false;
    /**
     * report页面是否分配功能点
     */
    public static final Boolean PAGE_REPORT_HAS_FUNCTION = false;

    /**
     * 词典文件位置
     */
    public static final String DICT_FILE_READ_PATH = "/dict.properties";
    /**
     * 生词保存位置
     */
    public static final String DICT_FILE_WRITE_PATH = "d:/dict.properties";

    /**
     * 白名单文件夹
     */
    public static String []WHITE_FOLDERS = {"META-INF", "WEB-INF"};

    /**
     * 判断文件夹是否为白名单文件夹
     * @param folderName
     * @return
     */
    public static boolean isWhiteFolder(String folderName) {
        for(String s : WHITE_FOLDERS) {
            if(folderName.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public static int getPreUrlLength() {
        return PROJECT_URL.length() + FOLDER_APPS.length() + 1;
    }
}
