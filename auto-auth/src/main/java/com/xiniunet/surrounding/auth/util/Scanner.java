package com.xiniunet.surrounding.auth.util;

import com.xiniunet.surrounding.auth.constans.Constants;
import com.xiniunet.surrounding.auth.domain.Application;
import com.xiniunet.surrounding.auth.domain.Product;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.xiniunet.surrounding.auth.constans.Constants.isWhiteFolder;

/**
 * Created on 2015-05-11.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class Scanner {

    public static void main(String[] args) {
        Constants.PROJECT_URL = "D:\\Workspace\\pm\\erp";
        Constants.PROJECT_CODE = "com.xiniunet.erp";
        Product product = Scanner.scanProject();
        try {
            DictUtil.saveProperties(product.getDict());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Product scanProject() {
        if(Constants.PROJECT_URL == null || Constants.PROJECT_URL.isEmpty()) {
            throw new RuntimeException("未选择项目路径");
        }

        Product product = new Product();
        product.setCode(Constants.PROJECT_CODE);
        String defaultAppName = getDefaultAppName();
        product.setDefaultAppName(defaultAppName);
        List<File> childFolderList = listAppFolder();
        List<String> xmlFileNameList = listAppName();

        // 对比webapp目录下的目录,与webx-xxx.xml文件,两者都有的才算为一个应用
        for(File file : childFolderList) {
            for(String s : xmlFileNameList) {
                if(file.getName().equals(s)) {
                    product.addApplication(new Application(file));
                    break;
                }
            }
        }

        return product;
    }

    /**
     * 列出所有应用目录下的目录.白名单在内的目录不列出.
     * @return
     */
    private static List<File> listAppFolder() {

        // 列出webapp目录下的所有应用
        File baseFolder = new File(Constants.PROJECT_URL + Constants.FOLDER_APPS);
        if( ! baseFolder.isDirectory()) {
            throw new RuntimeException("项目的路径目标需为项目根文件夹");
        }

        File[] files = baseFolder.listFiles();
        if(files == null) {
            files = new File[0];
        }

        List<File> childFolderList = new ArrayList<>();
        for(File tempFile : files) {
            if(tempFile.isDirectory() && !isWhiteFolder(tempFile.getName())) {
                childFolderList.add(tempFile);
            }
        }
        return childFolderList;
    }

    /**
     * 列出所有webx-xxx.xml中登记的应用名称
     * @return  满足webx-xxx.xml文件名称的所有应用名称
     */
    private static List<String> listAppName() {

        // 列出所有webx-xxx.xml文件
        File webInfoFolder = new File(Constants.PROJECT_URL + Constants.FOLDER_WEB_INFO);
        if( ! webInfoFolder.isDirectory()) {
            throw new RuntimeException("未找到WEB-INF目录");
        }

        File[] files = webInfoFolder.listFiles();
        if(files == null) {
            files = new File[0];
        }
        List<String> xmlFileNameList = new ArrayList<>();
        for(File tempFile : files) {
            if(tempFile.isFile()) {
                String fileName = tempFile.getName();
                if(fileName.startsWith("webx-") && fileName.endsWith(".xml")) {
                    String name = fileName.substring(5, fileName.length()-4);
                    xmlFileNameList.add(name);
                }
            }
        }
        return xmlFileNameList;
    }

    private static String getDefaultAppName() {
        File file = new File(Constants.PROJECT_URL + Constants.FILE_DEFAULT_WEBX_XML);
        if( ! file.isFile()) {
            throw new RuntimeException("默认webx配置文件不存在");
        }
        SAXReader saxReader = new SAXReader();
        Document childDoc;
        try {
            childDoc = saxReader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }

        Element rootElement = childDoc.getRootElement();

        Element configuration = rootElement.element("webx-configuration");

        Element components = configuration.element("components");

        return components.attributeValue("defaultComponent");
    }
}
