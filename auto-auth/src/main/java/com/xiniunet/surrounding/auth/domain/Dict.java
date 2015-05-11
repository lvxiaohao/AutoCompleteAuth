package com.xiniunet.surrounding.auth.domain;

import com.xiniunet.surrounding.auth.constans.Constants;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created on 2015-05-11.
 * AutoCompleteAuth
 *
 * @author 小昊
 * @since 1.0.0
 */
public class Dict {

    /**
     * 页面名称中出现的单词.
     * Key : 单词
     * Value : 出现过的位置
     */
    private Map<String, List<String>> page;

    /**
     * 文件夹名称中出现的单词.
     * Key : 单词
     * Value : 出现过的位置
     */
    private Map<String, List<String>> folder;

    /**
     * 应用名称中出现的单词.
     * Key : 单词
     * Value : 出现过的位置
     */
    private Map<String, List<String>> app;

    public Dict() {
        init();
    }
    public void clear() {
        init();
    }

    public void init() {
        page = new TreeMap<>();
        folder = new TreeMap<>();
        app = new TreeMap<>();
    }


    public Map<String, List<String>> getDict() {
        return page;
    }

    public void addWord(Type type, String word, String source) {
        Map<String, List<String>> temp;
        String cnSource ;
        switch (type) {
            case PAGE:
                temp = page;
                cnSource = "页面：";
                break;
            case FOLDER:
                temp = folder;
                cnSource = "文件夹：";
                break;
            case APP:
                temp = app;
                cnSource = "应用：";
                break;
            default:
                return;
        }
        if(temp.get(word) == null) {
            temp.put(word, new ArrayList<String>());
        }
        temp.get(word).add(cnSource + source);
    }

    public void addWord(Type type, File file) {
        if(file.isDirectory()) {
            addWord(type, file.getName(),
                    file.getAbsolutePath().substring(Constants.getPreUrlLength()));
        } else {
            addWord(type, file.getName().substring(0, file.getName().length() - 3),
                    file.getAbsolutePath().substring(Constants.getPreUrlLength()));
        }
    }

    public enum Type {
        PAGE,
        FOLDER,
        APP
    }
}
