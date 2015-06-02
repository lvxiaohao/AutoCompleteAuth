package com.xiniunet.surrounding.auth.util;

import com.xiniunet.surrounding.auth.domain.Catalog;
import com.xiniunet.surrounding.auth.domain.FileTree;
import com.xiniunet.surrounding.auth.domain.Application;
import com.xiniunet.surrounding.auth.domain.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
    public static void generatePageXml(Product product) throws JAXBException {
        FileTree fileTree = new FileTree();
        List<Catalog> catalogList = new ArrayList<>();
        Catalog catalog = new Catalog();
        catalogList.add(catalog);
        fileTree.setCatalogs(catalogList);

        for(Application application : product.getAppList()) {
            catalog.getPages().addAll(application.getPageList());
        }

        /**
         * 将流程定义对象转换为文本
         *
         * @param processDef 流程定义对象
         * @return 流程对应的文本
         */
        JAXBContext context = JAXBContext.newInstance(FileTree.class);
        // 根据上下文获取marshaller对象
        Marshaller marshaller = context.createMarshaller();
        // 设置编码字符集
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        // 格式化XML输出，有分行和缩进
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // 打印到控制台
        marshaller.marshal(fileTree, System.out);

//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        marshaller.marshal(root, stream);
//
//        String xmlObj = new String(stream.toByteArray());
//
//        String result = xmlObj.replace(" standalone=\"yes\"", "");

    }
}
