package com.xiniunet.surrounding.auth.util;

import com.xiniunet.surrounding.auth.constans.Constans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.xiniunet.surrounding.auth.constans.Constans.isWhiteFolder;

/**
 * Created on 2015-05-11.
 *
 * @author 吕浩
 * @since 1.0.0
 */
public class FolderScanner {



    public static List<File> scan() {
        if(Constans.PROJECT_URL == null || Constans.PROJECT_URL.isEmpty()) {
            throw new RuntimeException("未选择项目路径");
        }

        // 列出webapp目录下的所有应用
        File baseFolder = new File(Constans.PROJECT_URL + Constans.CHILD_URL);
        if( ! baseFolder.isDirectory()) {
            throw new RuntimeException("项目的路径目标需为项目根文件夹");
        }
        File[] files = baseFolder.listFiles();

        List<File> childFolderList = new ArrayList<File>();
        for(File tempFile : files) {
            if(tempFile.isDirectory() && !isWhiteFolder(tempFile.getName())) {
                childFolderList.add(tempFile);
            }
        }

        // 列出所有webx-xxx.xml文件
        File webInfoFolder = new File(Constans.PROJECT_URL + Constans.WEB_INFO_URL);
        if( ! webInfoFolder.isDirectory()) {
            throw new RuntimeException("未找到WEB-INF目录");
        }




        return null;
    }
}
